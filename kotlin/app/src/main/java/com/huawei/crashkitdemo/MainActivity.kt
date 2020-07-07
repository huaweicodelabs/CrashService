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
package com.huawei.crashkitdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.huawei.agconnect.crash.AGConnectCrash
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeCrashButton.setOnClickListener {
            AGConnectCrash.getInstance().testIt(applicationContext)
        }

        crashOnButton.setOnClickListener {
            AGConnectCrash.getInstance().enableCrashCollection(true)
        }

        crashOffButton.setOnClickListener {
            AGConnectCrash.getInstance().enableCrashCollection(false)
        }
    }
}
