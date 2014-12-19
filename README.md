yellowpress
===========

Used:
1) Cassandra version 2.1
2) Thrift compiler version 0.9.1
3) Twitter IAGO 6.2.4
4) scala 2.9.2

mvn package -DskipTests
mkdir tmp; cd tmp
unzip ../target/yellowpress-load-package-dist.zip
java -jar yellowpress-load-1.0-SNAPSHOT.jar -f ../config/yellowpress.scala
java -jar yellowpress-load-1.0-SNAPSHOT.jar -f ../config/yellowpress.scala -k

1. Add Storm to real data analyzing like:
 a) time : userId : newsId -- to support analytics for trends news during getting news by id
 b) time : userId : tag -- trends for tags (статистика посещения новостей по тегам)
 c) filtering content during adding new news item (for prohibited words etc)
 d) recommendations for similar news




 <!--<properties>-->
     <!--<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>-->
     <!--<mainClass>com.twitter.parrot.launcher.LauncherMain</mainClass>-->
     <!--</properties>-->

     <!--<repositories>-->
     <!--<repository>-->
     <!--<id>Twitter public Maven repo</id>-->
     <!--<url>http://maven.twttr.com</url>-->
     <!--</repository>-->
     <!--</repositories>-->

     <!--<pluginRepositories>-->
     <!--<pluginRepository>-->
     <!--<id>dtrott</id>-->
     <!--<url>http://maven.davidtrott.com/repository</url>-->
     <!--</pluginRepository>-->
     <!--<pluginRepository>-->
     <!--<id>Twitter public Maven repo</id>-->
     <!--<url>http://maven.twttr.com</url>-->
     <!--</pluginRepository>-->
     <!--</pluginRepositories>-->

     <!--<dependencies>-->
     <!--<dependency>-->
     <!--<groupId>org.apache.thrift</groupId>-->
     <!--<artifactId>libthrift</artifactId>-->
     <!--<version>0.5.0</version>-->
     <!--</dependency>-->
     <!--<dependency>-->
     <!--<groupId>com.netflix.astyanax</groupId>-->
     <!--<artifactId>astyanax</artifactId>-->
     <!--<version>2.0.2</version>-->
     <!--</dependency>-->
     <!--<dependency>-->
     <!--<groupId>com.netflix.astyanax</groupId>-->
     <!--<artifactId>astyanax-core</artifactId>-->
     <!--<version>2.0.2</version>-->
     <!--</dependency>-->
     <!--<dependency>-->
     <!--<groupId>com.netflix.astyanax</groupId>-->
     <!--<artifactId>astyanax-thrift</artifactId>-->
     <!--<version>2.0.2</version>-->
     <!--</dependency>-->
     <!--<dependency>-->
     <!--<groupId>junit</groupId>-->
     <!--<artifactId>junit</artifactId>-->
     <!--<version>4.10</version>-->
     <!--<scope>test</scope>-->
     <!--</dependency>-->


     <!--<dependency>-->
     <!--<groupId>org.apache.thrift</groupId>-->
     <!--<artifactId>libthrift</artifactId>-->
     <!--<version>0.9.1</version>-->
     <!--</dependency>-->

     <!--<dependency>-->
     <!--<groupId>com.twitter</groupId>-->
     <!--<artifactId>finagle-thrift_2.9.1</artifactId>-->
     <!--<version>4.0.2</version>-->
     <!--</dependency>-->

     <!--<dependency>-->
     <!--<groupId>org.slf4j</groupId>-->
     <!--<artifactId>slf4j-api</artifactId>-->
     <!--<version>1.5.8</version>-->
     <!--</dependency>-->

     <!--<dependency>-->
     <!--<groupId>org.slf4j</groupId>-->
     <!--<artifactId>slf4j-log4j12</artifactId>-->
     <!--<version>1.5.8</version>-->
     <!--</dependency>-->

     <!--<dependency>-->
     <!--<groupId>log4j</groupId>-->
     <!--<artifactId>log4j</artifactId>-->
     <!--<version>1.2.14</version>-->
     <!--</dependency>-->

     <!--<dependency>-->
     <!--<groupId>org.apache.commons</groupId>-->
     <!--<artifactId>commons-lang3</artifactId>-->
     <!--<version>3.1</version>-->
     <!--</dependency>-->

     <!--<dependency>-->
     <!--<groupId>com.twitter</groupId>-->
     <!--<artifactId>iago</artifactId>-->
     <!--<version>0.6.14</version>-->
     <!--</dependency>-->

     <!--</dependencies>-->

     <!--<build>-->
     <!--<plugins>-->
     <!--<plugin>-->
     <!--<groupId>com.twitter</groupId>-->
     <!--<artifactId>maven-build-properties-plugin</artifactId>-->
     <!--<configuration>-->
     <!--<buildPropertiesPackage>by.mmf.yellowpress.iago-echo</buildPropertiesPackage>-->
     <!--</configuration>-->
     <!--</plugin>-->
     <!--<plugin>-->
     <!--<groupId>com.twitter</groupId>-->
     <!--<artifactId>maven-finagle-thrift-plugin</artifactId>-->
     <!--<configuration>-->
     <!--<thriftGenerators>-->
     <!--<thriftGenerator>finagle</thriftGenerator>-->
     <!--</thriftGenerators>-->
     <!--</configuration>-->
     <!--<version>0.0.9</version>-->
     <!--</plugin>-->
     <!--<plugin>-->
     <!--<groupId>net.alchim31.maven</groupId>-->
     <!--<artifactId>scala-maven-plugin</artifactId>-->
     <!--<version>3.2.0</version>-->
     <!--<configuration>-->
     <!--<scalaCompatVersion>2.10.3</scalaCompatVersion>-->
     <!--<scalaVersion>2.10.3</scalaVersion>-->
     <!--</configuration>-->
     <!--<executions>-->
     <!--<execution>-->
     <!--<goals>-->
     <!--<goal>compile</goal>-->
     <!--<goal>testCompile</goal>-->
     <!--</goals>-->
     <!--<configuration>-->
     <!--<args>-->
     <!--<param>-unchecked</param>-->
     <!--<param>-deprecation</param>-->
     <!--<param>-encoding</param>-->
     <!--<param>utf8</param>-->
     <!--</args>-->

     <!--<jvmArgs>-->
     <!--<jvmArg>-Xmx2G</jvmArg>-->
     <!--</jvmArgs>-->
     <!--</configuration>-->
     <!--</execution>-->
     <!--</executions>-->
     <!--</plugin>-->
     <!--<plugin>-->
     <!--<groupId>org.apache.maven.plugins</groupId>-->
     <!--<artifactId>maven-surefire-plugin</artifactId>-->
     <!--<version>2.12</version>-->
     <!--<configuration>-->
     <!--<argLine>-Xmx1024m</argLine>-->
     <!--<redirectTestOutputToFile>false</redirectTestOutputToFile>-->
     <!--<includes>-->
     <!--<include>**/Test*.java</include>-->
     <!--<include>**/*Test.java</include>-->
     <!--<include>**/*Spec.java</include>-->
     <!--</includes>-->
     <!--</configuration>-->
     <!--</plugin>-->
     <!--<plugin>-->
     <!--<groupId>org.apache.thrift.tools</groupId>-->
     <!--<artifactId>maven-thrift-plugin</artifactId>-->
     <!--<version>0.1.11</version>-->
     <!--<configuration>-->
     <!--<thriftExecutable>/usr/local/bin/thrift</thriftExecutable>-->
     <!--</configuration>-->
     <!--<executions>-->
     <!--<execution>-->
     <!--<id>thrift-sources</id>-->
     <!--<phase>generate-sources</phase>-->
     <!--<goals>-->
     <!--<goal>compile</goal>-->
     <!--</goals>-->
     <!--</execution>-->
     <!--<execution>-->
     <!--<id>thrift-test-sources</id>-->
     <!--<phase>generate-test-sources</phase>-->
     <!--<goals>-->
     <!--<goal>testCompile</goal>-->
     <!--</goals>-->
     <!--</execution>-->
     <!--</executions>-->
     <!--</plugin>-->
     <!--<plugin>-->
     <!--<groupId>org.apache.maven.plugins</groupId>-->
     <!--<artifactId>maven-compiler-plugin</artifactId>-->
     <!--<version>2.3.2</version>-->
     <!--<configuration>-->
     <!--<source>1.7</source>-->
     <!--<target>1.7</target>-->
     <!--</configuration>-->
     <!--</plugin>-->

     <!--</plugins>-->
     <!--</build>-->
