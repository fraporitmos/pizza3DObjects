//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Fraporitmos on 10/10/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension HomeView {
    @MainActor class HomeViewModel: ObservableObject {
        
        private let getMoviesUseCase = GetAllPizzas.init()
        
        @Published private(set) var pizzas:[Pizza] = []

        func loadPizzas() async {
          
            do {
                
                let pizzas = try await getMoviesUseCase.invoke()
                                
                self.pizzas = self.pizzas + pizzas
                
            } catch {
               
                print(error.localizedDescription)
            }
        }
    }
}

