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
