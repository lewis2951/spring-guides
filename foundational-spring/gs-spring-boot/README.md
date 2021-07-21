## 启动 Spring Boot

有三种方式运行 `Spring Boot` 项目。

**方式一：直接运行**

每个 `Spring Boot` 项目仅有一个 `SpringBootApplication` 类，即本例中的 `Application.java`。

**方式二：特有方式**

每个 `Spring Boot` 项目均可以通过以下命令启动。

```bash
# 运行
mvn spring-boot:run
```

**方式三：打包执行**

每个 `Spring Boot` 项目均可打包为可执行 jar 包，本例路径为 `target\gs-spring-boot-1.0.jar`。

```bash
# 打包
mvn clean package

# 执行
java -jar target/gs-spring-boot-1.0.jar
```

## 监控 Spring Boot

**添加依赖**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

**默认情况**

添加 `Spring Boot Actuator` 依赖即可对应用程序进行监控，启动项目并访问 [监控地址][actuator]。

```json
{"_links":{"self":{"href":"http://localhost:8080/actuator","templated":false},"health-path":{"href":"http://localhost:8080/actuator/health/{*path}","templated":true},"health":{"href":"http://localhost:8080/actuator/health","templated":false}}}
```

通过以上信息可以看到，默认情况下，监控地址仅提供 [health 信息][health]。

```json
{"status":"UP"}
```

**打开所有 Endpoints**

在 `application.properties` 下配置：

```bash
management.endpoints.web.exposure.include=*
```

再次访问 [监控地址][actuator] 时，发现多了很多 Endpoints，常用的包括 [info][info] | [env][env] 等。

```json
{"_links":{"self":{"href":"http://localhost:8080/actuator","templated":false},"beans":{"href":"http://localhost:8080/actuator/beans","templated":false},"caches":{"href":"http://localhost:8080/actuator/caches","templated":false},"caches-cache":{"href":"http://localhost:8080/actuator/caches/{cache}","templated":true},"health":{"href":"http://localhost:8080/actuator/health","templated":false},"health-path":{"href":"http://localhost:8080/actuator/health/{*path}","templated":true},"info":{"href":"http://localhost:8080/actuator/info","templated":false},"conditions":{"href":"http://localhost:8080/actuator/conditions","templated":false},"configprops":{"href":"http://localhost:8080/actuator/configprops","templated":false},"configprops-prefix":{"href":"http://localhost:8080/actuator/configprops/{prefix}","templated":true},"env":{"href":"http://localhost:8080/actuator/env","templated":false},"env-toMatch":{"href":"http://localhost:8080/actuator/env/{toMatch}","templated":true},"loggers-name":{"href":"http://localhost:8080/actuator/loggers/{name}","templated":true},"loggers":{"href":"http://localhost:8080/actuator/loggers","templated":false},"heapdump":{"href":"http://localhost:8080/actuator/heapdump","templated":false},"threaddump":{"href":"http://localhost:8080/actuator/threaddump","templated":false},"metrics":{"href":"http://localhost:8080/actuator/metrics","templated":false},"metrics-requiredMetricName":{"href":"http://localhost:8080/actuator/metrics/{requiredMetricName}","templated":true},"scheduledtasks":{"href":"http://localhost:8080/actuator/scheduledtasks","templated":false},"mappings":{"href":"http://localhost:8080/actuator/mappings","templated":false}}}
```

**更详细的 health 信息**

默认情况下，health 信息仅显示状态值，要查看更多，需要添加以下配置。

```bash
management.endpoint.health.show-details=always
```

再次访问 [health 信息][health]。

```json
{"status":"UP","components":{"diskSpace":{"status":"UP","details":{"total":107374178304,"free":31129903104,"threshold":10485760,"exists":true}},"ping":{"status":"UP"}}}
```

发现 health 信息更全面，例如，可以 [查看硬盘占用情况][health-diskSpace]。

```json
{"status":"UP","details":{"total":107374178304,"free":31129903104,"threshold":10485760,"exists":true}}
```

**调整监控地址**

出于安全考虑，调整默认的监控地址是很有必要的。

```bash
management.endpoints.web.base-path=/manage
```

此时 [监控地址][manage] 路径由 `/actuator` 调整为 `/manage`。

```json
{"_links":{"self":{"href":"http://localhost:8080/manage","templated":false},"beans":{"href":"http://localhost:8080/manage/beans","templated":false},"caches-cache":{"href":"http://localhost:8080/manage/caches/{cache}","templated":true},"caches":{"href":"http://localhost:8080/manage/caches","templated":false},"health":{"href":"http://localhost:8080/manage/health","templated":false},"health-path":{"href":"http://localhost:8080/manage/health/{*path}","templated":true},"info":{"href":"http://localhost:8080/manage/info","templated":false},"conditions":{"href":"http://localhost:8080/manage/conditions","templated":false},"configprops":{"href":"http://localhost:8080/manage/configprops","templated":false},"configprops-prefix":{"href":"http://localhost:8080/manage/configprops/{prefix}","templated":true},"env":{"href":"http://localhost:8080/manage/env","templated":false},"env-toMatch":{"href":"http://localhost:8080/manage/env/{toMatch}","templated":true},"loggers":{"href":"http://localhost:8080/manage/loggers","templated":false},"loggers-name":{"href":"http://localhost:8080/manage/loggers/{name}","templated":true},"heapdump":{"href":"http://localhost:8080/manage/heapdump","templated":false},"threaddump":{"href":"http://localhost:8080/manage/threaddump","templated":false},"metrics-requiredMetricName":{"href":"http://localhost:8080/manage/metrics/{requiredMetricName}","templated":true},"metrics":{"href":"http://localhost:8080/manage/metrics","templated":false},"scheduledtasks":{"href":"http://localhost:8080/manage/scheduledtasks","templated":false},"mappings":{"href":"http://localhost:8080/manage/mappings","templated":false}}}
```

**更多配置**

还可以调整监控端口、限制访问路径等，更多配置可参考 [Spring Boot 官方指南][reference] 的监控部分。

[actuator]: http://localhost:8080/actuator
[manage]: http://localhost:8080/manage

[info]: http://localhost:8080/actuator/info
[env]: http://localhost:8080/actuator/env

[health]: http://localhost:8080/actuator/health
[health-diskSpace]: http://localhost:8080/actuator/health/diskSpace

[reference]: https://docs.spring.io/spring-boot/docs/2.5.2/reference/html/actuator.html
