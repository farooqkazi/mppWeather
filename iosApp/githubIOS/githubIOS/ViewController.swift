//
//  ViewController.swift
//  githubIOS
//
//  Created by Stanislav Gavrosh on 11/4/18.
//  Copyright © 2018 Stanislav Gavrosh. All rights reserved.
//

import UIKit
import SharedCode

class ViewController: UIViewController {
    @IBOutlet weak var temperatureLabel: UILabel!
    @IBOutlet weak var activityInd: UIActivityIndicatorView!
    
    var viewModel: WeatherViewModel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.viewModel = WeatherViewModel(stateListener: handleState)
    }
    
    func handleState(_ state: WeatherState) -> KotlinUnit {
        print("handle state \(state)")
        self.temperatureLabel.text = state.weatherDescription
        if (state.isLoading) {
            activityInd.startAnimating()
        } else {
            activityInd.stopAnimating()
        }
        return KotlinUnit.init()
    }
    
    @IBAction func loadWeather(_ sender: Any) {
        self.viewModel.loadWeather()
    }
}
