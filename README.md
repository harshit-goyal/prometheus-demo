# prometheus-demo
A Spring Boot application to create custom metrics.

Download Prometheus - https://prometheus.io/download/
Copy the file in your working directory.
Extract the file - tar xvfz <file-name> (I am using mac, you can change the commands based on your OS)
cd <extracted folder>
Start the server - ./prometheus

Start the Spingboot Application with your custome metrics
Check service is up or not - http://localhost:8080/actuator/health
Try hitting the rest end point - http://localhost:8080/test?number=5
Check your metrics is pushed or not at - http://localhost:8080/actuator/prometheus

Edit the Prometheus config file

scrape_configs:
  - job_name: 'prometheus'

    metrics_path: '/actuator/prometheus'
    scrape_interval: 3s
    static_configs:
    - targets: ['localhost:8080']
    
 Restart the Prometheus server.
 
 Kudos !!

