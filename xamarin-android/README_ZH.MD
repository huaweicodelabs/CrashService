介绍
此演示项目是演示Agconnect崩溃服务Xamar Android插件功能的示例。

安装

在解决方案资源管理器面板中，右键单击解决方案名称，然后选择管理NuGet包。搜索Huawei.Agconnect.AgconnectCash，并将该软件包安装到您的Xamarin.Android项目中。

将您的agconnect-services.json文件放置在项目中

步骤1：登录AppGallery Connect，从我的项目中选择您的项目。然后转到项目设置选项卡。在弹出的页面中，单击agconnect-services.json按钮。

步骤2：下载agconnect-services.json文件后，将其放置在演示项目的资产文件夹下。

步骤3:agconnect-services.json中的包名和AndroidManifest.xml中的包名应该一致

环境设置

Android 4.2（API级别17）及以上版本

构建和编译需要Visual Studio 2019 16.3或Visual Studio for Mac 2019 8.3的最低版本


测试步骤
步骤1：点击makeException触发非致命异常事件，点击CustomReport生成自定义崩溃报告，点击makeCrash触发崩溃，然后重新启动应用

步骤2：登录AGC网页查看崩溃报告。

许可和条款
Agconnect崩溃服务Xamar Android插件-演示是在Apache 2.0许可下获得许可的