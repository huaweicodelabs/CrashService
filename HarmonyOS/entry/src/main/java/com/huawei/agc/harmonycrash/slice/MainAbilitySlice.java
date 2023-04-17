/*
 * Copyright 2023. Huawei Technologies Co., Ltd. All rights reserved.
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
package com.huawei.agc.harmonycrash.slice;

import com.huawei.apm.crash.APMCrash;
import com.huawei.agc.harmonycrash.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.hiviewdfx.HiLog;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        APMCrash.getInstance().enableCrashReport(true);


        Button btn_crash = (Button) findComponentById(ResourceTable.Id_Make_Crash);
        btn_crash.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                APMCrash.getInstance().testJavaException(true);
            }
        });

        Button btn_exception = (Button) findComponentById(ResourceTable.Id_Make_Exception);
        btn_exception.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                try{
                    throw new Exception();
                }catch (Exception e){
                    APMCrash.getInstance().recordException(e);
                }
            }
        });

        Button btn_CustomReport = (Button) findComponentById(ResourceTable.Id_Custom_Report);
        btn_CustomReport.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                APMCrash.getInstance().setUserId("testuser");
                APMCrash.getInstance().setCustomLogInfo(HiLog.DEBUG,"set debug log.");
                APMCrash.getInstance().setCustomLogInfo(HiLog.INFO,"set info log.");
                APMCrash.getInstance().setCustomLogInfo(HiLog.WARN,"set warning log.");
                APMCrash.getInstance().setCustomLogInfo(HiLog.ERROR,"set error log.");
                APMCrash.getInstance().setCustomKeyValue("stringKey", "Hello world");
                APMCrash.getInstance().setCustomKeyValue("booleanKey", false);
                APMCrash.getInstance().setCustomKeyValue("doubleKey", 1.1);
                APMCrash.getInstance().setCustomKeyValue("floatKey", 1.1f);
                APMCrash.getInstance().setCustomKeyValue("intKey", 0);
                APMCrash.getInstance().setCustomKeyValue("longKey", 11L);
            }
        });


    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
