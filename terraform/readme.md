
# Java App Build in Jenkins Pipeline

  

Create an AWS instance with terraform

  

## Table of Contents

1.  [Description](#Description)

2.  [Dependencies](#Dependencies)

3.  [Installing](#Installing)

4.  [How to use it](#How-to-use-it)

5.  [Author](#Author)

  

## Description

  

Create an AWS instance with terraform and access to it in ssh

  

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

  

For remotly create your aws instance you need to put a *credentials* file in *terraform-files/*.

  

For be able to connect to your instance in ssh you need to generate your keys (thoses command need to be executed in *terraform-files/*):

```sh

mkdir ./ssh && ssh keygen -f ./ssh/id_rsa

```
Press enter until is done
>  `ssh keygen` is for generate keys.

  

>  `-f ./ssh/id_rsa` is the path you want for your keys.

Don't forget to write your public key in *add-ssh-web-app.yaml*
```yml
    ssh_authorized_keys: 
      - YOUR SSH KEY PUBLIC HERE
```

The result is :

  

![Tree](https://i.imgur.com/42yPq1A.png)

  

### How to create instance

  

To create the aws instance you need to connect to your [Jenkins](Localhost) and find the job terraform in IaC folder.

  

![Job](https://i.imgur.com/EMwElZB.png)

  
  

Then launch it and wait until the build is finished...

  

![Job](https://i.imgur.com/iZXYCtx.png)

  

The build is a success when you have in *jenkins console output*:
 ```
**Outputs:** 
instance_id = [
  "i-0f76339d18e84814e",
]
instance_public_ip = [
  "3.12.102.190",
] 
```

 
 And you can connect to your instance using ssh :
 ```sh
ssh -i ./ssh/id_rsa deploy@your_ip_public
```
## Author

  

Yanis BEN AMOR

  