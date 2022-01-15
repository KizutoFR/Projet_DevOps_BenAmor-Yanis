# CaC Ansible in Jenkins Pipeline

Java application deploy from ansible in Jenkins

## Table of Contents
1. [Description](#Description)
2. [Getting Started](#Getting-Started)
3. [Independencies](#Independencies)
4. [Installing](#Installing)

## Description

Ansible server with one playbook that deploy java application with parameters 

## Getting Started

### Dependencies

* Windows/Linux

* Docker and Docker Compose (jenkins server)

* Port 80 free (Jenkins use :80, change if you need)

### Installing

To install the project you need to run

```sh
docker-compose up -d
```
>  `docker-compose up` is for build the docker-compose.yml file.

>  `-d` is needed if you don't want to be stuck in the container console logs.

## Author

Yanis BEN AMOR