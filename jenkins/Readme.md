# Java App Build in Jenkins Pipeline

Build jar from an java application named SB3T 

## Table of Contents
1. [Description](#Description)
2. [Dependencies](#Dependencies)
3. [Installing](#Installing)
4. [How to use it](#How-to-use-it)
5. [Author](#Author)

## Description

Build .jar package from [Sb3t](https://github.com/Ozz007/sb3t) java application

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
> `docker-compose up` is for build the docker-compose.yml file.

> `-d` is needed if you don't want to be stuck in the container console logs.

### How to use it

To use this pipeline you need to connect to your [Jenkins](Localhost:8081) and find the job sb3t in CI folder.  

![Job](https://i.imgur.com/esvQ1OS.png)


Then launch it with your parameters and wait until the build is finished...  

![Job](https://i.imgur.com/9p5KtP5.png)

The Build is a success when you have a `sb3t-$versionNum-$versionType.jar` file in the workspace of your build

![Job](https://i.imgur.com/tG8opnl.png)

## Author

Yanis BEN AMOR
