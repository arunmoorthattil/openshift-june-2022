# Day 3

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
(jegan@tektutor.org)$ oc expose deploy/nginx --type=ClusterIP  --port=8080
service/nginx exposed
(jegan@tektutor.org)$ oc get svc
NAME    TYPE        CLUSTER-IP    EXTERNAL-IP   PORT(S)    AGE
nginx   ClusterIP   172.30.95.1   <none>        8080/TCP   4s
(jegan@tektutor.org)$ oc describe svc/nginx
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
