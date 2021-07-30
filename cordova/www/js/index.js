/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

// Wait for the deviceready event before using any of Cordova's device APIs.
// See https://cordova.apache.org/docs/en/latest/cordova/events/events.html#deviceready

var btn_MakeCrash = document.getElementById("MakeCrash");
var btn_MakeException = document.getElementById("MakeException");
var btn_CustomReport = document.getElementById("CustomReport");

document.addEventListener('deviceready', onDeviceReady, false);

function onDeviceReady() {
    btn_MakeCrash.addEventListener("click", MakeCrash);
    btn_MakeException.addEventListener("click", MakeException);
	btn_CustomReport.addEventListener("click", CustomReport);
}

function MakeCrash() {
    AGCCrashPlugin.testIt();
}

function MakeException() {
    try {
        throw new Error("js exception");
    } catch (e) {    
        AGCCrashPlugin.recordException(e.message, e.stack);
    }
}

function CustomReport() {
    AGCCrashPlugin.setUserId("testuser");
    AGCCrashPlugin.setCustomKey("hello world", "This is a world");
    AGCCrashPlugin.setCustomKey("number1", 1.12345678);
    AGCCrashPlugin.setCustomKey("number2", 1234567890);
    AGCCrashPlugin.setCustomKey("number3", -1234567890);
    AGCCrashPlugin.setCustomKey("number4", 0);
    AGCCrashPlugin.setCustomKey("boolean1", true);
    AGCCrashPlugin.setCustomKey("boolean2", false);
    AGCCrashPlugin.logWithLevel(2, "logWithLevel debug");
    AGCCrashPlugin.logWithLevel(3, "logWithLevel info");
    AGCCrashPlugin.logWithLevel(4, "logWithLevel warning");
    AGCCrashPlugin.logWithLevel(5, "logWithLevel error");
}
