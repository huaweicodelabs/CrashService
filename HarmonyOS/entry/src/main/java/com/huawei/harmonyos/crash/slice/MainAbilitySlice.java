package com.huawei.harmonyos.crash.slice;

import com.huawei.agconnect.crash.AGConnectCrash;
import com.huawei.harmonyos.crash.ResourceTable;
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

        Button btn_crash = (Button) findComponentById(ResourceTable.Id_Make_Crash);
        btn_crash.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                AGConnectCrash.getInstance().testIt(MainAbilitySlice.this);
            }
        });

        Button btn_exception = (Button) findComponentById(ResourceTable.Id_Make_Exception);
        btn_exception.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                try{
                    throw new Exception();
                }catch (Exception e){
                    AGConnectCrash.getInstance().recordException(e);
                }
            }
        });

        Button btn_CustomReport = (Button) findComponentById(ResourceTable.Id_Custom_Report);
        btn_CustomReport.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                AGConnectCrash.getInstance().setUserId("testuser");
                AGConnectCrash.getInstance().log(HiLog.DEBUG,"set debug log.");
                AGConnectCrash.getInstance().log(HiLog.INFO,"set info log.");
                AGConnectCrash.getInstance().log(HiLog.WARN,"set warning log.");
                AGConnectCrash.getInstance().log(HiLog.ERROR,"set error log.");
                AGConnectCrash.getInstance().setCustomKey("stringKey", "Hello world");
                AGConnectCrash.getInstance().setCustomKey("booleanKey", false);
                AGConnectCrash.getInstance().setCustomKey("doubleKey", 1.1);
                AGConnectCrash.getInstance().setCustomKey("floatKey", 1.1f);
                AGConnectCrash.getInstance().setCustomKey("intKey", 0);
                AGConnectCrash.getInstance().setCustomKey("longKey", 11L);

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
