# Migrating from Local MongoDB to AWS DocumentDB using AWS DMS (Database Migration Service)

### Overview
#### This document outlines the steps to migrate a local MongoDB database to AWS DocumentDB using AWS Database Migration Service (DMS). The migration process involves setting up the source and target endpoints, creating a replication instance, and configuring the migration task.

### Steps to Migrate a Local MongoDB Database to AWS DocumentDB

1. **Create your DocumentDB Cluster**: 
   - Go to the AWS Management Console and navigate to the Amazon DocumentDB service.
   - Create a new documentDB cluster. Make sure to note the cluster endpoint and port number.

2. **Configure Configure the localhost MongoDB**:
    - In this your local mongoDB, should have replica set enabled.
    - Make that port 27017 is open to the outside world. For this you follow below stetps
        - In firewall settings, allow port 27017 for incoming connections.
        - In firewall settings, allow port 27017 for outgoing connections.
        - Also from your default gateway url address, allow port forwarding for port 27017.
            `Application > NAT Configuration > NAT --Virtual Server Configuration > Add`

3. **Create a Replication Instance**:
   - In the AWS DMS console, create a new replication instance.
   - Choose the instance class and storage size based on your requirements.
   - Ensure that the replication instance is in the same VPC as your DocumentDB cluster.

4. **Create Source and Target Endpoints**:
   - In the AWS DMS console, create a new source and target endpoint.
   - Configure the source endpoint to connect to your local MongoDB instance, use you public IP address.
   - Configure the target endpoint to connect to your DocumentDB cluster using the cluster endpoint and port number.
   - Test the connection for both endpoints to ensure they are configured correctly.

5. **Create a Migration Task**:
    - In the AWS DMS console, create a new migration task.
    - Select the replication instance, source endpoint, and target endpoint.
    - Choose the migration type (full load, CDC, or both) based on your requirements.
    - Configure the table mappings and transformation rules as needed.
    - Start the migration task.