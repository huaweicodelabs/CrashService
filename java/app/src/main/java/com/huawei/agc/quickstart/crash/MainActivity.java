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

package com.huawei.agc.quickstart.crash;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.huawei.agc.quickstart.crash.R;
import com.huawei.agconnect.crash.AGConnectCrash;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_crash = findViewById(R.id.btn_crash);
        btn_crash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AGConnectCrash.getInstance().testIt(MainActivity.this);
            }
        });

        Button btn_exception = findViewById(R.id.btn_exception);
        btn_exception.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    throw new Exception();
                }catch (Exception e){
                    AGConnectCrash.getInstance().recordException(e);
                }
            }
        });

        findViewById(R.id.CustomReport).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AGConnectCrash.getInstance().setUserId("testuser");
                AGConnectCrash.getInstance().log(Log.DEBUG,"set debug log.");
                AGConnectCrash.getInstance().log(Log.INFO,"set info log.");
                AGConnectCrash.getInstance().log(Log.WARN,"set warning log.");
                AGConnectCrash.getInstance().log(Log.ERROR,"set error log.");
                AGConnectCrash.getInstance().setCustomKey("stringKey", "Hello world");
                AGConnectCrash.getInstance().setCustomKey("booleanKey", false);
                AGConnectCrash.getInstance().setCustomKey("doubleKey", 1.1);
                AGConnectCrash.getInstance().setCustomKey("floatKey", 1.1f);
                AGConnectCrash.getInstance().setCustomKey("intKey", 0);
                AGConnectCrash.getInstance().setCustomKey("longKey", 11L);

            }
        });

    }

}
