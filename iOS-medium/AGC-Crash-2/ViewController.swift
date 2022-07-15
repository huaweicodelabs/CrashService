/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import UIKit
import AGConnectCrash

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        let crashButton = UIButton(frame: CGRect(x: 50, y: 80, width: 160, height: 50))
        crashButton.backgroundColor = UIColor.blue
        crashButton.setTitle("Make Crash", for: .normal)
        crashButton.addTarget(self, action: #selector(makeCrash), for: .touchUpInside)
        self.view.addSubview(crashButton)

        let customReportButton = UIButton(frame: CGRect(x: 50, y: 160, width: 160, height: 50))
        customReportButton.backgroundColor = UIColor.blue
        customReportButton.setTitle("Custom Report", for: .normal)
        customReportButton.addTarget(self, action: #selector(customReport), for: .touchUpInside)
        self.view.addSubview(customReportButton)

    }

    @objc func makeCrash() {

        AGCCrash.sharedInstance().testIt()
    }

    @objc func customReport() {

        AGCCrash.sharedInstance().setUserId("testuser")
        AGCCrash.sharedInstance().log(level: .debug, message: "set debug log")
        AGCCrash.sharedInstance().log(level: .info, message: "set info log")
        AGCCrash.sharedInstance().log(level: .warning, message: "set warning log")
        AGCCrash.sharedInstance().log(level: .error, message: "set error log")
        AGCCrash.sharedInstance().setCustomValue(value: "Hello world", key: "stringKey")
        AGCCrash.sharedInstance().setCustomValue(value: false, key: "booleanKey")
        AGCCrash.sharedInstance().setCustomValue(value: 1.1, key: "doubleKey")
        AGCCrash.sharedInstance().setCustomValue(value: 1.1, key: "floatKey")
        AGCCrash.sharedInstance().setCustomValue(value: 0, key: "intKey")
        AGCCrash.sharedInstance().setCustomValue(value: 11, key: "longKey")

    }

}
