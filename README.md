# examserver
体检项目后端

#导入说明
在idea中点击file/import导入此项目，类型选择maven项目
导入后idea会自动进行依赖包下载，需要等待一段时间

#配置说明
数据库配置文件在src/resources目录下
application.yml的active: dev表示使用application-dev.yml配置
修改为active: prod则使用application-prod.yml配置，两个配置可以根据自身需要切换使用
数据库连接配置在application-dev.yml中
目前配置的是体检项目外网服务器

#其他
如果plsql连接oracle查看数据为中文乱码，则增加环境变量
NLS_LANG = SIMPLIFIED CHINESE_CHINA.ZHS16GBK  即可