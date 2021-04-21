#!/bin/bash

REPOSITORY=/home/ec2-user/freelec-springboot2-webservice
JAR_NAME=/home/ec2-user/freelec-springboot2-webservice/build/libs/*

nohup java -jar \
    -Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
    -Dspring.profiles.active=real \
    $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &