import SwiftUI
import Kingfisher
import shared
import SceneKit

struct HomeView: View {
    @StateObject var viewModel = HomeViewModel()
    @State private var isLoading = true
    
    var body: some View {
        NavigationView{
            VStack(alignment: .leading, spacing: 8){
                ScrollView{
                    LazyVGrid(columns: Array(repeating: GridItem(), count: 1), spacing: 2){
                        ForEach(viewModel.pizzas, id: \.id){pizza in

                            NavigationLink(destination: PizzaDetailView(pizza: pizza)) {
                                VStack(alignment: .leading, spacing: 8) {
                                    KFImage(URL(string: pizza.img)!)
                                        .resizable()
                                        .frame(maxWidth: .infinity)
                                        .frame(height: 200)
                                        .clipShape(RoundedRectangle(cornerRadius: 12))
                                        .shadow(radius: 5)

                                    HStack {
                                        Text(pizza.name)
                                            .font(.title2)
                                            .fontWeight(.bold)
                                            .foregroundColor(.black)
                                            .lineLimit(2)
                                            .multilineTextAlignment(.leading)
                                        
                                
                                        Spacer()
                                        
                                        Text("S/" + String(describing: pizza.price))
                                            .font(.title)
                                            .fontWeight(.bold)
                                            .foregroundColor(.black)
                                            .lineLimit(1)
                                    }.padding(8)


                                    Text(pizza.desc)
                                        .font(.body)
                                        .foregroundColor(.black)
                                        .lineLimit(2)
                                        .multilineTextAlignment(.leading)
                                        .padding(8)
                                }

                                .frame(maxWidth: 350)
                                .background(Color.white) // Color de fondo
                                .cornerRadius(12) // Corner radius
                                .shadow(radius: 5) // Sombra
                                .padding(8)
                            }
                        }
                    }
                }

            }
        }.onAppear {
            Task {
                await viewModel.loadPizzas()
                isLoading = false
            }
        }
	}

}

