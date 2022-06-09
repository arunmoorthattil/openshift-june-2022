# Day 2 - OpenShift

##### ℹ️ Installing Code Ready Containers in Linux
:x: Please do not try this in our lab environment as it will corrupt our OpenShift cluster installation.  These instructions are here to help you in setting up OpenShift in your personal laptop/desktop post the training for your self-learning purposes only.

```
cd ~/Downloads
tar xvf crc-linux-amd64.tar.xz
cd crc-linux-1.38.0-amd64
./crc setup
```

The expected output is
<pre>
jegan@ubuntu:~/Downloads/crc-linux-1.38.0-amd64$ <b>./crc setup</b>
INFO Checking if running as non-root              
INFO Checking if running inside WSL2              
INFO Checking if crc-admin-helper executable is cached 
INFO Checking for obsolete admin-helper executable 
INFO Checking if running on a supported CPU architecture 
INFO Checking minimum RAM requirements            
INFO Checking if crc executable symlink exists    
INFO Checking if Virtualization is enabled        
INFO Checking if KVM is enabled                   
INFO Checking if libvirt is installed             
INFO Checking if user is part of libvirt group    
INFO Checking if active user/process is currently part of the libvirt group 
INFO Checking if libvirt daemon is running        
INFO Checking if a supported libvirt version is installed 
INFO Checking if crc-driver-libvirt is installed  
INFO Installing crc-driver-libvirt                expose
INFO Checking crc daemon systemd service          
INFO Setting up crc daemon systemd service        
INFO Checking crc daemon systemd socket units     
INFO Setting up crc daemon systemd socket units   
INFO Checking if AppArmor is configured           
INFO Updating AppArmor configuration              
INFO Using root access: Updating AppArmor configuration 
[sudo] password for jegan: 
INFO Using root access: Changing permissions for /etc/apparmor.d/libvirt/TEMPLATE.qemu to 644  
INFO Checking if systemd-networkd is running      
INFO Checking if NetworkManager is installed      
INFO Checking if NetworkManager service is running 
INFO Checking if dnsmasq configurations file exist for NetworkManager 
INFO Checking if the systemd-resolved service is running 
INFO Checking if /etc/NetworkManager/dispatcher.d/99-crc.sh exists 
INFO Writing NetworkManager dispatcher file for crc 
INFO Using root access: Writing NetworkManager configuration to /etc/NetworkManager/dispatcher.d/99-crc.sh 
INFO Using root access: Changing permissions for /etc/NetworkManager/dispatcher.d/99-crc.sh to 755  
INFO Using root access: Executing systemctl daemon-reload command 
INFO Using root access: Executing systemctl reload NetworkManager 
INFO Checking if libvirt 'crc' network is available 
INFO Setting up libvirt 'crc' network             
INFO Checking if libvirt 'crc' network is active  
INFO Starting libvirt 'crc' network               
INFO Checking if CRC bundle is extracted in '$HOME/.crc' 
INFO Checking if /home/jegan/.crc/cache/crc_libvirt_4.9.12.crcbundle exists 
INFO Extracting bundle from the CRC executable    
INFO Ensuring directory /home/jegan/.crc/cache exists 
INFO Extracting embedded bundle crc_libvirt_4.9.12.crcbu:moneybag:ndle to /home/jegan/.crc/cache 
INFO Uncompressing crc_libvirt_4.9.12.crcbundle   
crc.qcow2: 11.69 GiB / 11.69 GiB [------------------------------------------------------] 100.00%
oc: 117.16 MiB / 117.16 MiB [-----------------------------------------------------------] 100.00%
Your system is correctly setup for using CodeReady Containers, you can now run 'crc start' to start the OpenShift cluster
</pre>

##### ℹ️ Starting your local CRC OpenShift Cluster
:x:  Please don't attempt this in our training lab.

```
./crc start
```
The expected output is
<pre>
[jegan@tektutor crc-linux-1.38.0-amd64]$ <b>./crc start</b>
INFO Checking if running as non-root              
INFO Checking if running inside WSL2              
INFO Checking if crc-admin-helper executable is cached 
INFO Checking for obsolete admin-helper executable 
INFO Checking if running on a supported CPU architecture 
INFO Checking minimum RAM requirements            
INFO Checking if crc executable symlink exists    
INFO Checking if Virtualization is enabled        
INFO Checking if KVM is enabled                   
INFO Checking if libvirt is installed             
INFO Checking if user is part of libvirt group    
INFO Checking if active user/process is currently part of the libvirt group 
INFO Checking if libvirt daemon is running        
INFO Checking if a supported libvirt version is installed 
INFO Checking if crc-driver-libvirt is installed  
INFO Checking crc daemon systemd socket units     
INFO Checking if systemd-networkd is running      
INFO Checking if NetworkManager is installed      
INFO Checking if NetworkManager service is running 
INFO Checking if /etc/NetworkManager/conf.d/crc-nm-dnsmasq.conf exists 
INFO Checking if /etc/NetworkManager/dnsmasq.d/crc.conf exists 
INFO Checking if libvirt 'crc' network is available 
INFO Checking if libvirt 'crc' network is active  
INFO Starting CodeReady Containers VM for OpenShift 4.9.12... 
INFO CodeReady Containers instance is running with IP 192.168.130.11 
INFO CodeReady Containers VM is running           
INFO Check internal and public DNS query...       
INFO Check DNS query from host...                 
INFO Verifying validity of the kubelet certificates... 
INFO Starting OpenShift kubelet service           
INFO Waiting for kube-apiserver availability... [takes around 2min] 
INFO Waiting for user's pull secret part of instance disk... 
INFO Starting OpenShift cluster... [waiting for the cluster to stabilize] 
INFO All operators are available. Ensuring stability... 
INFO Operators are stable (2/3)...                
INFO Operators are stable (3/3)...                
INFO Adding crc-admin and crc-developer contexts to kubeconfig... 
Started the OpenShift cluster.
penShift Installer Provisioned Ins
The server is accessible via web console at:
  https://console-openshift-console.apps-crc.testing

Log in as administrator:
  Username: kubeadmin
  Password: B8XxM-aY9yz-zhwJY-5HU7d

Log in as user:expose
  Username: developer
  Password: developer

Use the 'oc' command line interface:
  $ eval $(crc oc-env)
  $ oc login -u developer https://api.crc.testing:6443
[jegan@tektutor crc-linux-1.38.0-amd64]$ 
</pre>
when the crc prompts for pull secret, you need to paste the content of pull-secret.txt and hit enter.

##### ℹ️ Troubleshooting CRC start
:x:  Please don't attempt this in our training lab.

It is commonly noticed that ./crc start command fails many times. 

Make sure

1. Virtualization is enabled (VT-X/AMD-V)
2. You have sufficient RAM in the system atleast 16GB or more
3. You have alteast 8 vCPU in your system

Try to stop and startAgreement

```
./crc stop
./crc start
```

##### ℹ️ Login to CRC Cluster as a developer via CLI
:x:  Please don't attempt this in our training lab.

```
eval $(./crc oc-env)
oc login -u developer https://api.crc.testing:6443
```

##### ℹ️ Login to CRC Cluster as an administrator via CLI
:x:  Please don't attempt this in our training lab.

```
eval $(./crc oc-env)
oc login -u kubeadmin https://api.crc.testing:6443
```

## ℹ️ Using RedHat OpenShift Developer Sandbox for Free 👨‍🎓

🔴🔴🔴 As we already have a working OpenShift Cluster pre-installed, you don't have to do this during the training.🔴🔴🔴

You may setup a RedHat Cluster almost instantaneously and very helpful for self-learning.  However, some advanced features like Eventing, installing Operators, etc will not work in this Free environment.

https://developers.redhat.com/developer-sandbox?source=sso

## ℹ️ OpenShift Installer Provisioned Infrastructure (IPI) 💲💲💲
This mode of OpenShift installation is preferred if budget is not a constraint and you wish to perform the OpenShift installation in Cloud environments or with VMWare vSphere, etc.,

However, this style of Openshift installation offers less flexibility or configuration options but the installation efforts will be less, as pretty much the installer automates creating infrastructure (VMs, Network, OS installation, etc) and end-to-end OpenShift installation procedure.

### ℹ️ Story time - my personal experience
I recently installed RedHat OpenShift in AWS. 

I used the OpenShift cluster for 9 days

The automatic installation spinned off 

On Demand Linux Amazon Elastic Compute Cloud running Linux/Unix costed - $420
- EC2 m5.xlarge Instance ( 4 vCPU with 16 GB RAM ) 
- EC2 r5.xlarge Instance ( 4 vCPU with 32 GB RAM - good for memory intensive computing )
- EC2 m5.2xlarge ( 8 vCPU with 32 GB RAM )

Amazon NAT Gateway costed $94 
Load Balancing - $20 

The total bill was :heavy_dollar_sign::heavy_dollar_sign: $707(rounded) :angry: including :disappointed: :disappointed: GST $107.83 for 9 Days. This is way too expensive for your learning purpose, this is more suitable for :heavy_check_mark: corporates :moneybag: :heavy_dollar_sign: i.e Development :heavy_check_mark: & Production :heavy_check_mark:.

 :-1: Not recommended for self-learning

You may refer more details about this in the official documentation
https://docs.openshift.com/container-platform/4.9/installing/index.html

## :heavy_check_mark: OpenShift User Provisioned Infrastructure (UPI)
This mode of OpenShift installation is highly preferred :thumbsup: and flexible :satisfied: in many cases. This approach let's you take control of the installation process, allows you to customize things giving more flexibily in setting up your OpenShift in your own preferred way. 

But this involves doing everything manually yourself :weary: .  This is a very lengthy process and many things can go wrong during the installation, hence installing OpenShift using this approach involves several attempts but the end result almost always will be fruitful as you would have learned many things along the way :v:

I remember the first time I attempted this it took about 7 days :tired_face: to get my cluster up and running. The official documentations are very exhaustive and no single approach works in all environment, hence there are always many missing pieces of information without which things won't work in your environment. You need to find your solution for the puzzle all by yourself.  Sometimes it takes few minutes, few hours and sometimes it takes few days to find out the missing piece of information. It is like solving a puzzle. But once you have figured out what works in your environment, you can do the setup within 1 hour.


## Container Orchestration Platform
- manages containers
- provides an environment for applications that guarantees High Availability (HA)
- supports in-built monitoring features
- support self-healing when our application goes unresponsive
- supports scaling up/down our microservice/applications
- supports rolling update
    - upgrading your live application from one version to other without downtime
- supports rollback in case the newly rolled out application version is found to be unstable
- load balances the application pods behind services
- RBAC(Role Based Access Control)
- products 
    - Docker SWARM ( supports only Docker Container Engine )
    - Google Kubernetes ( supports many types of Container Engines including Docker)
    - RedHat OpenShift ( is developed on top of Kubernetes, supports CRI-O container runtime & Podman container engine)
    - Rancher Kubernetes ( GUI for Kubernetes )
    - AWS EKS - Managed Kubernetes Service from Amazon
    - Azure AKS - Managed Kubernetes Service from Azure
    - AWS ROSA - Managed RedHat OpenShift from Amazon
    - Azure OpenShift - Managed RedHat OpenShift from Azure

On-premise(on-prem) datacenters
- datacenter
   - a single datacenter has several thousands of servers in a particular region
   - each Bank may have 100s of such datacenters in different regions and cross-geo locations

Private Cloud
  - VMWare vCenter
  - OpenStack
  - is AWS/Azure like features supported within in an Organization from the datacenters
    owned by your organization

Public Cloud
  - AWS
  - Azure
  - GCP
  - Digital Ocean
    
Hybrid Cloud
  - Partly some servers comes from your privately owned Datacenters
  - Partly some servers comes from Amazon AWS
  - Partly some servers comes from Microsoft Azure

Services offered by Cloud Vendors
- Infrastructure as a Service (IaaS)
    - Here we rent a Hardware
    - Pay as you go - pay only for the time we used the hardware(server)
    - Let's say we used AWS S3, we only pay for how much time we used the particular
      amount of Storage
    - We need to bring the Operating System License
    - Installing OS, performing Security patches on the OS is your organization's responsibility
    - The cloud vendor is only responsible for the HA of the H/W
    - Taking backup, upgrading OS is your organization's responsibility
    - For example
      - ec2 instances (Virtual Machines)
      - many ec2 instances can be created from a single Physical Server
      - it is technically possible that many companies would have created ec2 instances
        on the same shared server
    - ec2 level security is assured by AWS
    - OS/software/your application security is your organization's responsibility
    - Network/Internet services are provided by AWS as part of the plan
    - For every of ec2 instances you create, by default some amount of storage also
      are supported, but you could customize and choose different type of storage and size of storage 
- Platform as a Service (PaaS)
  - HW + OS the cloud vendors offers on pay as you go model
  - We just need to bring the softwares that needs to installed on top of the OS
  - Software back is still our responsibility
  - HW + OS HA is taken care by cloud vendor
  - cloud vendor is responsible for security patch, updates, etc.,
  - securing the OS is the responsibility of cloud vendor
- Software as a Service (SaaS)
  - HW + OS + Application is managed by cloud vendor
  - we will given access to the application
  - we just need to feed the application data and focus on our project
  - Backup, recovery, security is all taken care by cloud vendor

## Kubernetes Overview
- Google developed this Container Orchestration Platform using Go programming language
- Google used this orchestration platform internally for several years
- opensource product
- no support, only community level support is there without any SLA
- it is a time tested platform
- it supports loadbalancers, services, High Availibility, scaling up/down, rolling updates, etc
- Kubernetes supports many types of built-in resources
   - Deployment
   - ReplicaSet
   - Pod
   - Services
       - ClusterIP Service ( Internal - are accessible only within the cluster)
       - NodePort Service (External - are accessible outside the cluster )
       - LoadBalancer Service (External - meant for cloud environments like AWS/Azure, etc.,)
   - Job
   - Ingress
   - IngressController
- Appilcations are deployed in Kubernetes as Deployment
- Deployment has one or more ReplicaSets
- Each ReplicaSet manages one or more Pods
- Each ReplicaSet represents a single version of the application
- Pod is a collection of related containers
- the smallest unit that can be deployed in a Kubernetes is a Pod
- In Kubernetes IP address is assigned only on the Pod level ( In docker, each container gets a IP Address).
  In a Pod, there can be many containers running, all the containers within the same Pod shares the same IP.
- Kubernetes allows us adding our own custom resources(CR) by creating a CustomResourceDefinition (CRD) yaml file
- Using CRDs, one can extend the Kubernetes API ( features )
- CRDs just add more types of Resources into the Kubernetes Cluster, but we also need to deploy custom Controllers
  to manage our Custom Resources
  
## Kubernetes High-Level Architecture
![Kubernetes Architecture](K8sArchitecture.png)
  
## Kubernetes Labels
  - key/value pair
  - eg: app=nginx
  - labels can assigned to kind of resource in Kubernetes
  - the use of labels
  - Deployment identifies the Replicaset by using labels

## Deployment
   - will select the replicaset
   - kubectl get replicasets -l app=nginx
   - Deployment manages ReplicaSet

## Replicaset
   - will select the Pods based on some matching labels
   - ReplicaSet manages Pod
   - kubectl get pods -l app=nginx

## RedHat OpenShift
- is RedHat's distribution of Kubernetes
- is developed on top of Kubernetes
- Using Kubernetes CRDs and Custom Controllers, RedHat added several useful features on top of Kubernetes
- OpenShift is nothing but Kubernetes + additional CRs and addition Controllers
- OpenShift supports Private Container Registry within the OpenShift out of the box
- OpenShift suppports CI/CD within OpenShift cluster
- Openshift supports user management based on RBAC out of the box
- Applications can be deployed from
   - source code (S2I - Source to Image)
   - a Dockerfile
   - container image
   - imperatively and declaratively

## OpenShift High Level Architecture

- RedHat OpenShift supported Docker Container Engine till v3.x.  Starting from OpenShift v4.x, Docker Container Engine is completely replaced with CRI-O and Podman.
- RedHat OpenShift mandates using RedHat Enterprise Linux Core OS (RHCOS) on all master nodes
- RedHat OpenShift recommendes using RHCOS on worker nodes but allows to choose between RHEL and RHCOS on Worker Nodes
- RHCOS is custom build OS optimized for Containerized Applications that are managed within OpenShift Cluster.
- RHCOS comes with CRI-O and Podman pre-installed
- When RHCOS is used on all nodes, upgrading cluster from one version to other is easy as the process is completely automated, in case you chose RHEL for your Worker Nodes, upgrading the cluster will have to managed by ourselves.

#### High Level Architecture
![OpenShift High Level Architecture](RedHatOpenShiftArchitecture.png)

#### Master Node
![Openshift Master Node](master-node.png)


## Tekton K-native CI/CD Framework
- a Framework that works within Kubernetes/OpenShift
- Tekton adds its own CRs and Custom Controllers on top of Kubernetes/OpenShift to support CI/CD with the Orchestration platform cluster
- it is a serverless unline Jenkins CI/CD

## RedHat OpenShift Architecture

[!OpenShift Architecture]()

## OpenShift CLI commands

### Creating a project from command line
In OpenShift, applications are deployed within a project namespace.  Technically, project is nothing but namespace.
Different teams can create their own project and isolate their application deployments from others.

```
oc new-project <your-name>
oc new-project jegan
```
Expected output
<pre>
(jegan@tektutor.org)$ <b>oc new-project jegan</b>
Now using project "jegan" on server "https://api.ocp.tektutor.org:6443".

You can add applications to this project with the 'new-app' command. For example, try:

    oc new-app rails-postgresql-example

to build a new example application in Ruby. Or use kubectl to deploy a simple Kubernetes application:

    kubectl create deployment hello-node --image=k8s.gcr.io/e2e-test-images/agnhost:2.33 -- /agnhost serve-hostname
</pre>

### Deploying an application within a project

Check your project
```
oc project
```

You can deploy nginx as shown below
```
oc create deploy nginx --image=nginx:latest
```

Expected output
<pre>
(jegan@tektutor.org)$ <b>oc create deploy nginx --image=nginx:latest</b>
deployment.apps/nginx created
</pre>


### Listing the deployments
```
oc get deployments
oc get deployment
oc get deploy
```

Expected output
<pre>
(jegan@tektutor.org)$ <b>oc get deployments</b>
NAME    READY   UP-TO-DATE   AVAILABLE   AGE
nginx   0/1     1            0           2m25s
</pre>

### Listing the replicases
```
oc get replicasets
oc get replicaset
oc get rs
```

Expected output
<pre>
(jegan@tektutor.org)$ <b>oc get replicasets</b>
NAME               DESIRED   CURRENT   READY   AGE
nginx-7c658794b9   1         1         0       4m22s
(jegan@tektutor.org)$ <b>oc get replicaset</b>
NAME               DESIRED   CURRENT   READY   AGE
nginx-7c658794b9   1         1         0       4m31s
(jegan@tektutor.org)$ <b>oc get rs</b>
NAME               DESIRED   CURRENT   READY   AGE
nginx-7c658794b9   1         1         0       4m38s
</pre>

### Listing pods
```
oc get pods
oc get pod
oc get po
```

Expected output is
<pre>
(jegan@tektutor.org)$ <b>oc get pods</b>
NAME                     READY   STATUS             RESTARTS       AGE
nginx-7c658794b9-2wmmx   0/1     CrashLoopBackOff   5 (106s ago)   5m31s
(jegan@tektutor.org)$ oc get pod
NAME                     READY   STATUS             RESTARTS       AGE
nginx-7c658794b9-2wmmx   0/1     CrashLoopBackOff   5 (108s ago)   5m33s
(jegan@tektutor.org)$ oc get po
NAME                     READY   STATUS             RESTARTS       AGE
nginx-7c658794b9-2wmmx   0/1     CrashLoopBackOff   5 (111s ago)   5m36s
</pre>

### Deleting a deployment
```
oc delete deploy/nginx
```

Expected output
<pre>
(jegan@tektutor.org)$ <b>oc delete deploy/nginx</b>
deployment.apps "nginx" deleted
</pre>


### Let's redeploy the nginx deployment with bitnami/nginx image
```
oc create deploy nginx --image=bitnami/nginx:lates
```

### List the deployment, replicaset and pods in a single command
```
oc get deploy,rs,po
```

### Scaling up the nginx deployment
```
oc scale deploy/nginx --replicas=3
```

### Scaling down the nginx deployment
```
oc scale deploy/nginx --replicas=1
```

### Creating an external NodePort service for nginx deployment
```
oc expose deploy/nginx --type=NodePort --port=8080
```
Expected output
<pre>
(jegan@tektutor.org)$ <b>oc expose deploy nginx --type=NodePort --port=8080</b>
service/nginx exposed
</pre>

### Listing the services
```
oc get services
oc get service
oc get svc
```

Expected ouptut
<pre>
(jegan@tektutor.org)$ <b>oc expose deploy nginx --type=NodePort --port=8080</b>
service/nginx exposed
(jegan@tektutor.org)$ <b>oc get services</b>
NAME    TYPE       CLUSTER-IP       EXTERNAL-IP   PORT(S)          AGE
nginx   NodePort   172.30.152.102   <none>        8080:30316/TCP   6s
(jegan@tektutor.org)$ <b>oc get service</b>
NAME    TYPE       CLUSTER-IP       EXTERNAL-IP   PORT(S)          AGE
nginx   NodePort   172.30.152.102   <none>        8080:30316/TCP   8s
(jegan@tektutor.org)$ <b>oc get svc</b>
NAME    TYPE       CLUSTER-IP       EXTERNAL-IP   PORT(S)          AGE
nginx   NodePort   172.30.152.102   <none>        8080:30316/TCP   11s
</pre>
