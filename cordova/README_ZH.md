AGConnect科尔多瓦崩溃演示
在根目录下，执行以下操作：

步骤1：执行以下命令安装npm依赖$ npm install

第二步：执行以下命令创建对应的平台代码$科尔多瓦平台add android

步骤3：执行以下命令下载并安装AGC崩溃插件$科尔多瓦插件add @科尔多瓦插件-agconnect/crash--save

步骤4：将相应的agconnect-services.json/agconnect-services.plist放入相应的目录

第6步：将agcp-pl添加到相应的bulid.gradle中（仅Android）

应用插件：'com.huawei.agconnect'