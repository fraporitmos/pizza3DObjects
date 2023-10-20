import SwiftUI
import shared
import _SceneKit_SwiftUI
import Combine

struct PizzaDetailView: View {
    let pizza: Pizza
      public init(pizza: Pizza) {
          self.pizza = pizza
      }
    
    @State private var scene: SCNScene? = nil
    private var cancellables: Set<AnyCancellable> = []

  
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {

            if let scene = scene {
                SceneView(scene: scene, options: [.autoenablesDefaultLighting, .allowsCameraControl])
                    .frame(width: UIScreen.main.bounds.width, height: UIScreen.main.bounds.height / 2)
            } else {
                Text("Loading 3D Object...") 
            }
            
            Text(pizza.name)
                .font(.title)
                .fontWeight(.bold)
                .multilineTextAlignment(.leading)
                .padding(16)
     
            Text(pizza.desc)
                .font(.body)
                .fontWeight(.bold)
                .multilineTextAlignment(.leading)
                .padding(16)

        }

        .onAppear {
            downloadAndLoad3DModel()
        }
    }

    func downloadAndLoad3DModel() {
        guard let url = URL(string: pizza.obj_ios) else { return }
        let urlSession = URLSession.shared
        let downloadTask = urlSession.downloadTask(with: url) { localURL, _, error in
            if let localURL = localURL {
                do {
                    let documentsPath = FileManager.default.temporaryDirectory
                    let tempFileName = "temp.usdz"
                    let destinationURL = documentsPath.appendingPathComponent(tempFileName)
                    if FileManager.default.fileExists(atPath: destinationURL.path) {
                        try FileManager.default.removeItem(at: destinationURL)
                    }

                    try FileManager.default.copyItem(at: localURL, to: destinationURL)
                    if let scene = try? SCNScene(url: destinationURL, options: nil) {
                        DispatchQueue.main.async {
                            self.scene = scene
                        }
                    }
                } catch {
                    print("Error loading 3D model: \(error)")
                }
            } else if let error = error {
                print("Error downloading 3D model: \(error)")
            }
        }
        downloadTask.resume()
    }

}
