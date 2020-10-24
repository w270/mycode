# 说明
druid 下的schema不能自动执行，先去掉了
整合Mybatis 两种方法
1. @Mapper注解就行
   @Select("select * from department where id=#{id}")
   
2. 配置文件
   @Mapper或者@MapperScan将接口扫描装配到容器中
   
   //application.yml
   mybatis:
     # 指定全局配置文件位置
     config-location: classpath:mybatis/mybatis-config.xml
     # 指定sql映射文件位置
     mapper-locations: classpath:mybatis/mapper/*.xml