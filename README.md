# ath-cloud kotlin 多模块项目

### 项目结构：
ath-cloud 父模块
--ath-auth 子模块（暴露接口，依赖公共模块）
--ath-common 子模块（公共模块）
--ath-consul 子模块（暴露接口）

父模块配置文件
setting.gradle
```groovy
rootProject.name = 'ath-cloud'

//include 'ath-common','ath-consul', 'ath-auth'
//子模块 管理上面是简写
include 'ath-common'
include 'ath-auth'
include 'ath-consul'
```
build.gradle
```groovy
buildscript {
  ext {
    kotlinVersion = '1.2.41'
    springBootVersion = '2.0.3.RELEASE'
  }
  repositories {
    mavenLocal()
    maven { url "http://maven.aliyun.com/nexus/content/groups/public/" }
    mavenCentral()
    maven { url "https://repo.spring.io/plugins-release" }
    maven { url "https://jitpack.io" }
  }
  dependencies {
    classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
    classpath("org.jetbrains.kotlin:kotlin-allopen:${kotlinVersion}")
  }
}

apply plugin: 'kotlin'
apply plugin: 'kotlin-spring'
apply plugin: 'eclipse'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

group = 'com.gitee'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = 1.8

compileKotlin {
  kotlinOptions {
    freeCompilerArgs = ["-Xjsr305=strict"]
    jvmTarget = "1.8"
  }
}
compileTestKotlin {
  kotlinOptions {
    freeCompilerArgs = ["-Xjsr305=strict"]
    jvmTarget = "1.8"
  }
}

repositories {
  mavenLocal()
  maven { url "http://maven.aliyun.com/nexus/content/groups/public/" }
  mavenCentral()
  maven { url "https://repo.spring.io/plugins-release" }
  maven { url "https://jitpack.io" }
}
//所有子模块项目公共配置
subprojects {
  apply plugin: 'kotlin'
  apply plugin: 'maven'

  jar { enabled = true }
  bootJar { enabled = false }

  ext {
    kotlinVersion = '1.2.41'
    springBootVersion = '2.0.3.RELEASE'
    spec_version = '1.1.1'
    jpa_version='2.0.1.RELEASE'
  }

  repositories {
    mavenCentral()
  }

  compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }
  compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }

  dependencies {
    testCompile("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
  }


  repositories {
    mavenLocal()
    maven { url "http://maven.aliyun.com/nexus/content/groups/public/" }
    mavenCentral()
    maven { url "https://repo.spring.io/plugins-release" }
    maven { url "https://jitpack.io" }
  }
}
```
ath-common gradle配置文件
build.gradle
```groovy
group 'com.gitee'
version '0.0.1-SNAPSHOT'

repositories {
  mavenCentral()
}

dependencies {
  compile "org.springframework.boot:spring-boot-starter-data-jpa:$jpa_version"//jpa
  compile "net.kaczmarzyk:specification-arg-resolver:$spec_version"//jpa tool
  compile("org.springframework.boot:spring-boot-starter-web:$springBootVersion")

  compile('org.springframework.boot:spring-boot-starter')
  compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  compile "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
}
```
ath-auth gradle 配置文件
build.gradle
```groovy
group 'com.gitee'
version '0.0.1-SNAPSHOT'

repositories {
  mavenCentral()
}

//设置打包启动类
jar {
  manifest {
    attributes 'Main-Class': 'com.gitee.auth.AuthApplication'
  }
}

dependencies {
  compile project(":ath-common")//模块依赖
  compile('mysql:mysql-connector-java:6.0.6')
}
```
Spring boot项目启动时
要修改扫描的包，不然service，repository，entity注入失败
```kotlin
@EnableJpaRepositories("com.gitee")
@EntityScan("com.gitee")
@SpringBootApplication(scanBasePackages = ["com.gitee"])
open class AuthApplication

fun main(args: Array<String>) {
//  runApplication<AuthApplication>(*args)
  SpringApplication.run(AuthApplication::class.java, *args)
}
```