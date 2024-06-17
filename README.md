# Desafio_Libreria
Desarrollo desafío librería de Alura

Presento el siguiente error
```
Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2024-06-16T19:50:20.093-05:00 ERROR 15940 --- [  restartedMain] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Failed to initialize dependency 'flywayInitializer' of LoadTimeWeaverAware bean 'entityManagerFactory': Error creating bean with name 'flywayInitializer' defined in class path resource [org/springframework/boot/autoconfigure/flyway/FlywayAutoConfiguration$FlywayConfiguration.class]: Unable to obtain connection from database: Access denied for user 'root'@'localhost' (using password: YES)
----------------------------------------------------------------------------------------------------------
SQL State  : 28000
Error Code : 1045
Message    : Access denied for user 'root'@'localhost' (using password: YES)

	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:326) ~[spring-beans-6.1.8.jar:6.1.8]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:205) ~[spring-beans-6.1.8.jar:6.1.8]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:952) ~[spring-context-6.1.8.jar:6.1.8]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:624) ~[spring-context-6.1.8.jar:6.1.8]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.3.0.jar:3.3.0]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:754) ~[spring-boot-3.3.0.jar:3.3.0]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:456) ~[spring-boot-3.3.0.jar:3.3.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:335) ~[spring-boot-3.3.0.jar:3.3.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1363) ~[spring-boot-3.3.0.jar:3.3.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1352) ~[spring-boot-3.3.0.jar:3.3.0]
	at com.gutendexapp.GutendexAppApplication.main(GutendexAppApplication.java:11) ~[classes/:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:50) ~[spring-boot-devtools-3.3.0.jar:3.3.0]
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'flywayInitializer' defined in class path resource [org/springframework/boot/autoconfigure/flyway/FlywayAutoConfiguration$FlywayConfiguration.class]: Unable to obtain connection from database: Access denied for user 'root'@'localhost' (using password: YES)
----------------------------------------------------------------------------------------------------------
SQL State  : 28000
Error Code : 1045
Message    : Access denied for user 'root'@'localhost' (using password: YES)

	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1788) ~[spring-beans-6.1.8.jar:6.1.8]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600) ~[spring-beans-6.1.8.jar:6.1.8]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:522) ~[spring-beans-6.1.8.jar:6.1.8]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:337) ~[spring-beans-6.1.8.jar:6.1.8]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.8.jar:6.1.8]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:335) ~[spring-beans-6.1.8.jar:6.1.8]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-6.1.8.jar:6.1.8]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:313) ~[spring-beans-6.1.8.jar:6.1.8]
	... 15 common frames omitted
Caused by: org.flywaydb.core.internal.exception.FlywaySqlException: Unable to obtain connection from database: Access denied for user 'root'@'localhost' (using password: YES)
----------------------------------------------------------------------------------------------------------
SQL State  : 28000
Error Code : 1045
Message    : Access denied for user 'root'@'localhost' (using password: YES)

	at org.flywaydb.core.internal.jdbc.JdbcUtils.openConnection(JdbcUtils.java:60) ~[flyway-core-10.10.0.jar:na]
	at org.flywaydb.core.internal.jdbc.JdbcConnectionFactory.<init>(JdbcConnectionFactory.java:72) ~[flyway-core-10.10.0.jar:na]
	at org.flywaydb.core.FlywayExecutor.execute(FlywayExecutor.java:134) ~[flyway-core-10.10.0.jar:na]
	at org.flywaydb.core.Flyway.migrate(Flyway.java:147) ~[flyway-core-10.10.0.jar:na]
	at org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer.afterPropertiesSet(FlywayMigrationInitializer.java:66) ~[spring-boot-autoconfigure-3.3.0.jar:3.3.0]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1835) ~[spring-beans-6.1.8.jar:6.1.8]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1784) ~[spring-beans-6.1.8.jar:6.1.8]
	... 22 common frames omitted
Caused by: java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:130) ~[mysql-connector-j-8.3.0.jar:8.3.0]
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-j-8.3.0.jar:8.3.0]
	at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:815) ~[mysql-connector-j-8.3.0.jar:8.3.0]
	at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:438) ~[mysql-connector-j-8.3.0.jar:8.3.0]
	at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:241) ~[mysql-connector-j-8.3.0.jar:8.3.0]
	at com.mysql.cj.jdbc.NonRegisteringDriver.connect(NonRegisteringDriver.java:189) ~[mysql-connector-j-8.3.0.jar:8.3.0]
	at com.zaxxer.hikari.util.DriverDataSource.getConnection(DriverDataSource.java:137) ~[HikariCP-5.1.0.jar:na]
	at com.zaxxer.hikari.pool.PoolBase.newConnection(PoolBase.java:360) ~[HikariCP-5.1.0.jar:na]
	at com.zaxxer.hikari.pool.PoolBase.newPoolEntry(PoolBase.java:202) ~[HikariCP-5.1.0.jar:na]
	at com.zaxxer.hikari.pool.HikariPool.createPoolEntry(HikariPool.java:461) ~[HikariCP-5.1.0.jar:na]
	at com.zaxxer.hikari.pool.HikariPool.checkFailFast(HikariPool.java:550) ~[HikariCP-5.1.0.jar:na]
	at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:98) ~[HikariCP-5.1.0.jar:na]
	at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:111) ~[HikariCP-5.1.0.jar:na]
	at org.flywaydb.core.internal.jdbc.JdbcUtils.openConnection(JdbcUtils.java:48) ~[flyway-core-10.10.0.jar:na]
	... 28 common frames omitted

```
