# Day 2 - OpenShift

## Container Orchestration Platform
- manages containers
- provides an environment for applications that guarantees High Availability
- supports inbuilt monitoring tools
- support self-healing when our application goes unresponsive
- supports scaling up/down our microservice/applications
- supports rolling update
    - upgrading your live application from one version to other without downtime
- supports rollback in case the newly rolled out application version is found to
  unstable
- load balance
- RBAC(Role Based Access Control)
- products 
    - Docker SWARM ( supports only Docker Container Engine )
    - Google Kubernetes ( supports many types of Container Engine including Docker)
    - RedHat OpenShift ( is developed on top of Kubernetes, supports CRI-O containers)
    - Rancher Kubernetes ( GUI for Kubernetes )
    - AWS EKS - Managed Kubernetes Service from Amazon
    - Azure AKS - Managed Kubernetes Service from Azure
    - AWS ROSA - Managed RedHat OpenShift from Amazon
    - Azure OpenShift - Managed RedHat OpenShift from Azure

On-premise(on-prem) datacenters
- datacenter
   - in a single datacenter has several thousands of servers in a particular region
   - each Bank may have 100s of such datacenters in different cross-geo locations

Private Cloud
  - VMWare vcenter
  - OpenStack
  - is AWS/Azure like features supported within in Organization from the datacenters
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
    - Installing OS, performing Security on the OS is your organization's responsibility
    - The cloud vendor is only responsible for the HA of the H/W
    - Taking backup, upgrading OS is your's organization's responsibility
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
- it is opensource
- no support, only community level support is there without any SLA
- it is a time tested platform
- it supports loadbalances, services, High Availibility, scaling up/down, rolling updates, etc
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
- Application when deployed within Kubernetes, they are deployed as Deployment
- Deployment has one or more ReplicaSet
- Each ReplicaSet manages one or more Pods
- Each ReplicaSet represents a single version of the application
- Pod is a collection of related containers
- the smallest unit that can be deployed in a Kubernetes is a Pod
- In Kubernetes IP address is assigned only on the Pod level ( In docker, each container gets a IP Address).
  In a Pod, there can be many containers running, all the containers within the same Pod shares the same IP.
- Kubernetes allows us adding our own custom resources(CR) by creating a CustomResourceDefinition (CRD) yaml
- Using CRDs, one can extend the Kubernetes API ( features )
- CRDs just add more types of Resources into the Kubernetes Cluster, but we also need to add Custom Controllers
  to manage our Custom Resources
  
## Kubernetes Labels
  - key/value pair
  - eg: app=nginx
  - labels can assigned to kind of resource in Kubernetes
  - the use of labels
  - Deployment identifies the Replicaset by using labels

Deployment
   - will select the replicaset
   - kubectl get replicasets -l app=nginx
   - Deployment manages ReplicaSet

Replicaset
   - will select the Pods based on some matching labels
   - ReplicaSet manages Pod
   - kubectl get pods -l app=nginx

## RedHat OpenShift
- is RedHat's distribution of Kubernetes
- is developed on top of Kubernetes
- Using Kubernetes CRDs and Custom Controllers, RedHat added several useful features on top of Kubernetes
- OpenShift is nothing but Kubernetes + additional CRs and addition Controllers
- OpenShift supports Private Container Registry within the OpenShift out of the box
- OpenShift suppports CI/CD within the OpenShift
- Applications can be deployed from
   - source code (S2I - Source to Image)
   - a Dockerfile
   - from container image
 
# Tekton K-native CI/CD Framework
- a Framework which works within Kubernetes also supported in OpenShift
- Tekton adds its own CRs and Custom Controllers on top of Kubernetes/OpenShift to support CI/CD with Orchestration platform.
