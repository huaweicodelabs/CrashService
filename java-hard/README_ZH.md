#崩溃快速启动

##简介
AppGallery Connect Cash提供轻量级崩溃分析服务，无需编码即可快速集成，帮助您快速了解版本质量，发现和解决崩溃问题，评估问题影响。

##环境准备
在使用快速启动应用程序之前，请准备好Android开发环境。


##环境要求
Android Studio 3.0或更高版本。

##配置
在运行快速启动应用程序之前，您需要：
1、如果您没有HUAWEI Developer帐户，则需要注册帐户并通过身份验证。
2、使用您的帐户登录AppGallery Connect，创建应用，套餐类型选择APK（Android应用）。
3.单击您刚刚创建的应用程序，进入开发>质量>崩溃。（Cash服务集成了HUAWEI Analysis Kit用于崩溃事件上报，因此在集成Cash SDK之前，需要启用HUAWEI Analysis Kit。）
4、从AppGallery Connect下载agconnect-services.json文件，并替换快速启动应用的JSON文件。

##示例代码
崩溃SDK支持崩溃模拟和崩溃收集开关设置。
示例代码： src\main\java\com\huawei\agc\quickstart\crash\MainActivity.java

##许可证
崩溃快速启动在【Apache许可证，版本2.0】（http://www.apache.org/licenses/LICense-2.0）下获得许可。