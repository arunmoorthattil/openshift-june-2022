# Day 3

## Deployment vs DeploymentConfig

- Initial version of Kubernetes supported only ReplicationController
- There was no Deployment or ReplicaSet.  Only ReplicationController was there.
- ReplicationController was responsible for Scaling up/down and Rolling update
- Off late, Kubernetes they wanted to break down the functionality of 
  ReplicationController into two Resources i.e Deployment and ReplicaSet
- For backward compatility, even today OpenShift/Kubernetes support ReplicationController also along side Deployment and Replicaset.


OpenShift team they created DeploymentConfig at the time Kubernetes was not supporting Deployment & ReplicaSet.

Gradually Kubernetes added Deployment and Replicaset as a replacement for ReplicationController.

OpenShift retained DeploymentConfig and as a response to Kubernetes Deployment, OpenShift also started supported Deployment & Replicaset.

In OpenShift, we can deploy application in two ways
1. Using Deployment ( Kubernetes style of application deployment )
2. Using DeploymentConfig ( OpenShift's style of application deployment )

## Deleting a service
```
oc delete svc/nginx
```

## Creating a ClusterIP Internal service
```
oc expose deploy/nginx --type=ClusterIP  --port=8080
```

Expected output
<pre>
(jegan@tektutor.org)$ <b>oc expose deploy/nginx --type=ClusterIP  --port=8080</b>
service/nginx exposed
(jegan@tektutor.org)$ <b>oc get svc</b>
NAME    TYPE        CLUSTER-IP    EXTERNAL-IP   PORT(S)    AGE
nginx   ClusterIP   172.30.95.1   <none>        8080/TCP   4s
(jegan@tektutor.org)$ <b>oc describe svc/nginx</b>
Name:              nginx
Namespace:         jegan
Labels:            app=nginx
Annotations:       <none>
Selector:          app=nginx
Type:              ClusterIP
IP Family Policy:  SingleStack
IP Families:       IPv4
IP:                172.30.95.1
IPs:               172.30.95.1
Port:              <unset>  8080/TCP
TargetPort:        8080/TCP
Endpoints:         10.128.0.84:8080,10.131.0.22:8080
Session Affinity:  None
Events:            <none>
</pre>

## Creating a LoadBalancer External Service

Delete any existing service
```
oc delete svc/nginx
```

Let's create the LoadBalancer service
```
oc expose deploy/nginx --type=LoadBalancer --port=8080
```

List the LoadBalancer Service
```
oc get svc
```

You can access the Loadbalancer as shown below
```
curl 192.168.122.190:8080
```
In the above command, 192.168.122.190 is the external IP address assigned to the MetalLB 


## What internally happens when we create a deployment in OpenShift with the below command?

```
oc create deploy nginx --image=bitnami/nginx:latest
```

1. oc client tool will send a request to API Server by making a REST call with all details in the command above.

2. API Server once it receives the request from oc client tool, it creates a deployment entry in the etcd database.

3. After creating the nginx Deployment entry in the etcd database, API Server broadcasts an event something like "New Deployment created".

4. Deployment Controller receives the event "New Deployment created" and then makes REST call request to the API Server to create a ReplicaSet.

5. API Server receives the request from Deployment Controller and creates a ReplicaSet as requested by Deployment Controller into the etcd database.

6. API Server will broadcast a event like "New ReplicaSet created".

7. ReplicaSet Controller receives the event, it will checks the replicas request and then it makes a REST call to API Server to create so many Pods.

8. API creates Pod entries in the etcd database as requested by ReplicaSet Controller.

9. API Server will broadcase an event like "New Pods created."

10. Scheduler receives the event, identifies healthy Nodes to deploy those Pods. Scheduler sends the scheduling recommendations to API Server via REST call.

11. API Server then updates the scheduling information in the already existing Pod definitions in the etcd database.

12. API Server will broadcast an event saying "Pod scheduled to Node<x>".

13. Kubelet running on the respective Node receives the event, it then creates Pod on the node where Kubelet is running and reports the status to API Server via REST call.

14. API Server updates the Pod status in the etcd database.

15. Kubelet constantly monitors the health of the Pods on the node where kubelet is
    running and sends a heart-beat kind of updates to API Server via REST call.


