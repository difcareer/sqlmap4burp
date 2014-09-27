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





