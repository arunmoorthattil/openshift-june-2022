# Day 1 - Docker

## Boot Loaders
- LILO
- GRUB ( 1 & 2 )
- Linux OS they all come with GRUB 2 
- Only one OS can be active at any point
- You can technically install many OS in the same system but only one OS can be active OS at any point in time

## Virtualization Technology
- is also referred as Hypervisor
- this technology helps us run many Operating Systems side by side on the same machine (Laptop/Desktop/Workstation/Server)
- many OS can be active on the same system simultaneously
- it is combination of Hardware & Software technology
  - Processor
    AMD
      - AMD-V is the virtualization feature supported on the AMD processor
    Intel
      - VT-X is the virtualization feature supported on the Intel processor
- There are two types of Hypervisors available
  1. Type 1  ( Bare Metal Hypervisors - Servers )
       - doesn't require Host OS
       - it can be directly installed on a bare server
       - https://www.vmware.com/topics/glossary/content/bare-metal-hypervisor.html
  2. Type 2  ( We install on Laptops/Desktops/Workstations )
       - requires HOST OS
       - i.e it can only be installed on top a Host Operating System ( Windows, Mac OS-X, Unix/Linux )
- Without Virtualization Technology 1000 Physical servers are required to support 1000 OS
- Server consolidation is possible with the help of Virtualization Technology
- With Virtualization, how many physical servers are required to support 1000 OS
   - technically it is possible with 1 Physical server you could host 1000 Virtual machines
   - or in normal scenarios may be 4~5 physical servers could easily support 1000 virtual machines
- What is the deciding factor which control the max Virtual machines supported?
    - configuration of the machine
    - Processors
        - multi-core 
    - RAM
    - Storage (Hard Disk )
- Hyperthreading
    - each physical cpu core are seen by the Hypervisor(virtualization) software as 2 or more logical cores
    - 1 physical core will be detected by the virtualization softwares as 2 Logical cores
    - Example
        - let's you have Processor that supports 256 core
        - it would be seen by the Virtualization software as 512 logical cores

- In case of Type2 virtualization, there will be two kind of Operating System
   1. Host Operating System
   2. Virtual Machine (VM - Guest Operating System )
- In case of Type1 virtualization, there will only one kind of Operating System
   - Virtual Machine ( VM - Guest Operating System )

- Virtualization Software Examples
   Oracle 
      - VirtualBox ( Free ) - Type 2
   VMWare
      - Fusion (Mac OS-X) - Type 2
      - Workstation ( Unix/Linux/Windows ) - Type 2
      - vSphere/VCenter ( Type 1 - Hypervisor )
      - Player ( Free on Windows )
   Parallels
      - Mac OS-X - Type 2 ( Commercial License is required )
   Microsoft
      - Hyper-V ( Type 2 ) ( Comes with Licensed OS )
   
   Kernal Virtual Manager (KVM) - Open source supported in all Linux OS
   
   
## Container Technology
- is a fundamentally a Linux technology
- Linux Kernel supports
   1. Namespace ( Isolation )
   2. Control Groups (CGroup) - applying hardware resource quota restrictions
 - LXC ( Lightweight Containership )
    - this was directly using the Linux Kernel Namespace & Control Group to support containers
    - but the commands weren't that user-friendly
    - bit low-level
    - not adapted by the industry that much
 - Docker from Docker Inc organization
     - comes in 2 flavours
       1. Community Edition - Docker CE
       2. Enterpise Edition - Docker EE
 - Containers has its own Network Stack ( 7 OSI Layers )
 - Every containers get its own IP Address ( typically private IP )
 - Every container has a file system 
 - Every container has its own Port range 0 - 65535
 - is not an OS
 - is just an application process that runs in a separate namespace
 - technically we can create containers directly using the system calls ( Linux namespace & CGroups )
 - but using Docker Container Engine it is more easier to create containers without knowing any low-level OS/kernel details it is easy to create container with Docker or similar container softwares

## Container Engine
- a high-level tool that can support managing Container Images and Containers with the help of many other tools
- is capable of managing containers with the help of Container Runtimes
- Docker is a container Engine that depends on runc container runtime to manage containers

## Container Runtime
- is the tool that is capable of managing containers
   - creates containers
   - start/stop/restart/kill/abort containers
- they don't know how to build image or manage container images
- example:
  - runc is a container runtime that is used by many Container Engines including Docker

## Docker Overview
- developed by Docker Inc organization using Go programming language

# Docker Alternatives
- LXC
- Podman
- Rkt ( pronounced as Rocket )

## Docker Image
- similar to ISO operating system image file
- containers can be created only via Docker Image
- any software that you want on the container level are generally pre-installed in the Docker Image
- Docker Image will not have OS Kernel
- Docker Image will have a package manager like apt(apt-get) if it is a Ubuntu Docker Image
- Docker Image will have a yum package manager if it is a CentOS Docker Image but still will not have Linux kernel.

## Docker Container
- Docker containers are created using the Docker Image
- Many containers can be created from a single Docker Image
- is an instance of Docker Image
- get's an IP address
- containers get's its file system from the Docker Image
- get's its own copy of network stack
- get's its own ports ( 0 - 65535 )

## Docker Public/Remote Registry
- Public Docker Registry is a web portal maintained by Docker Inc (Docker Hub)
- hosts a lot of Docker images
- any images you push here are accessible to entire open source community

## Docker Private Registry
- Optionally your organization can setup a private docker registry
- will host many public images and private proprietary Docker images
- JFrog Artifactory or Sonatype Nexus can be used to setup a Private Docker Registry
    - production grade
- optionally can also use docker.io/registry:latest docker image to setup private docker registry
  - good for prototype
  - lightweight setup - very helpful for laptops
  - not recommended for production

## Docker Local Registry
- this is local folder created and maintained by Docker Engine ( Docker Server )

## Finding the docker version
```
docker --version
```

## Listing Docker Images in the Local Docker Registry
```
docker images
```

## Downloading an image from Docker Hub to Local Docker Registry
```
docker pull alpine:latest
```

## Deleting an Docker Image from Local Registry
```
docker rmi ubuntu:20.04
```

## Creating a container in the interactive(foreground) mode
This command will take you inside the container's shell interactively
```
docker run -it --name c1 --hostname c1 alpine:latest /bin/sh
```
In order to come out of the container's shell, you need to type exit.  This will exit the container.

## Creating a container in the daemon/deattached(background) mode
```
docker run -dit --name c1 --hostname c1 alpine:latest /bin/sh
```

## Listing all running containers
```
docker ps
```

## Getting inside conainter shell
```
docker exec -it <container-id> /bin/bash
docker exec -it <container-name> /bin/bash
docker exec -it <container-name> bash
```

## Stop a running container
```
docker stop <container_id>
docker stop <container_name>
```

## Restart a running container
```
docker restart <container_id>
docker restart <container_name>
```

## Start a stopped container
```
docker start <container_id>
docker start <container_name>
```

## Delete a container
```
docker rm <container_id>
docker rm <container_name>
```
## Deleting multiple containers
```
docker rm <container_id1> <container_id2> <container_id3>
docker rm <container_name1> <container_name2> <container_name3>
docker rm $(docker ps -aq)
```

## Stopping and deleting multiple containers
```
docker stop $(docker ps -q) && docker rm $(docker ps -aq)
```

## Renaming a container
Recommended practice is to use only lowercase while naming containers.
```
docker rename <old-container-name> <new-container-name>
```

## Finding IP address of a running container
```
docker inspect <container-id>
docker inspect <container-id> | grep IPA
docker inspect <container-name> | grep IPA
docker inspect -f {{.NetworkSettings.IPAddress}} <container-name>
```

## Committing a container as a Docker image
You may manually install some software tools and may commit it as a container image.

Though this works, from DevOps point of view this isn't recommended.

```
docker commit <container-id> <image-name:tag>
docker commit <container-name> <image-name:tag.
docker commit ubuntu1 tektutor/ubuntu-vim:1.0
```

## Storing application data in a external volume as opposed to container storage

- Storing application data in a container storage is considered a bad practice
- Container orchestration platform in the process scale up/down it might delete any container, hence you
  will lose the data stored in container storage
- the recommended practice is to store application log/data in an external volume ( hostpath, AWS S3, Block storage provided by your cloud vendor, etc.,)

First create a folder in your home directory.
```
mkdir -p ~/tmp/tomcat
```
Create a html file
```
echo "Tomcat Works!" > ~/tmp/tomcat/index.html
```

Let's create a container
```
docker run -d --name tomcat1 --hostname tomcat1 -v ~/tmp/tomcat:/usr/local/tomcat/webapps/tektutor tomcat:latest
```

Find the IP address of your container
```
docker inspect tomcat1| grep IPA
```

Test and see if you can access the web page hosted inside the container
```
curl <container-ip>:8080/tektutor/index.html
```

Expected ouptut
<pre>
Tomcat Works!
</pre>

## Copying a file from your host system path to container
```
docker cp file-name-in-your-local-system <container-name>:<container-absolute-path>
```

## Copying a file from the container to your local machine current directory
```
docker cp <container-name>:<container-absolute-path>/<file-name> .
```


