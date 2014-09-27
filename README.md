一款集成sqlmap到burpsuite中的插件（整合两大神器）

在网上寻找类似的插件，发现了一款：https://code.google.com/p/gason/

不过对windows支持并不好，于是自己动手开发一款

配置：

1. 首先安装sqlmap，传送门：http://sqlmap.org/

2. 将sqlmap.py加入到path中（在cmd中输入sqlmap.py不会报找不到文件）

3. 下载依赖的jar包： commons-io-2.4.jar，放置到burpsuite java 插件的classpath下，burpsuite中配置路径为：extender-->options-->Java Environment

4. 编译此项目为单独的一个jar文件，添加到burpsuite的java插件中，配置路径为：extender-->extentions-->add

5. 之后你将会看到在主页面中会新增一个tab，名字叫做Sqlmap

使用：

本插件实现原理：将目标请求的数据存放到临时文件中，然后调用"sqlmap.py -r $file"来启动对请求的sql注入检测
在Sqlmap tab中，你可以配置sqlmap除 -r外的其他参数，比如：

加入配置中写："--level 3",真实执行时是：sqlmap.py -r $file --level 3

回到



a sqlmap plugin for burpsuite

config:

1. install sqlmap link is:http://sqlmap.org/

2. set sqlmap.py to your path

3. download the dependent jar:commons-io-2.4.jar,put it in your burpsuite java plugin's classpath

4. build this project to a single jar,add this jar to burpsuite's java plugin

5. you will find a new tab named "sqlmap" added to the main tabs 


usage:

1. this plugin dumps a target request into a temp file,and then call the "sqlmap -r $file" to start sql injection check.

2. in the sqlmap tab,you can add other parameters to the sqlmap.py

eg: config "--level 3" means "sqlmap -r $file --level 3"

3. now,back to the request list(eg: in proxy->history),right click mouse,find "send to Sqlmap",click it,it will start a dos-window for the sql injection check


attentions:

1. this tool is made on windows,other os need some modifications

2. any questions,please contact me:latershowwwc@gmail.com





