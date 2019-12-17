# Guides 规划

Spring 官网 Guides 系列教程，按照 Spring in Action (5th Edition) 的目录结构，教程分了5个部分：

* Part I: Foundational Spring
* Part II: Integrated Spring
* Part III: Reactive Spring
* Part IV: Cloud-Native Spring
* Part V: Deployed Spring

这是第一部分，重点关注 Spring 基础：

1. Getting started with Spring
2. Developing web applications
3. Working with data
4. Securing Spring
5. Working with configuration properties

# Projects 说明

## Getting started with Spring

这里聚焦 Spring Boot 快速入门，由下面三个例子体现。

* gs-spring-boot
* gs-batch-processing
* gs-scheduling-tasks

## Developing web applications

这里聚焦 Spring MVC 相关内容，包括表单提交、附件上传、异步请求。

* gs-serving-web-content
* gs-handling-form-submission
* gs-uploading-files
* gs-async-method

多模块和单元测试，因为都是基于 Web 工程，也归为这一章。

* gs-multi-module
* gs-testing-web

## Working with data

这一章转移到后台数据库技术，首先是传统的 JDBC、MySQL关系型数据库、JPA和事务处理。

* gs-relational-data-access
* gs-accessing-data-mysql
* gs-accessing-data-jpa
* gs-managing-transactions

接着，结合前端页面，完成 CRUD 和 表单验证。

* gs-crud-with-vaadin
* gs-validating-form-input

NoSQL 也是目前的主流，这里列举四个有代表性的 NoSQL 数据库。

* gs-accessing-data-mongodb
* gs-accessing-data-neo4j
* gs-accessing-data-gemfire
* gs-accessing-data-r2dbc

最后，关于后台数据，看看数据缓存如何实现。

* gs-caching
* gs-caching-gemfire

## Securing Spring

完成 Spring MVC 和 后台数据后，这里聚焦 Spring 的安全。

* gs-authenticating-ldap
* gs-securing-web

# 源码

本资源库采用 Maven 管理项目，仅用于本人学习和知识整理，所有源码版权归原作者所有。

# 技术栈

* JDK: 1.8
* Spring Boot: 2.2.2.RELEASE
