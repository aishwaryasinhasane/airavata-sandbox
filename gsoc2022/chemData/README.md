# Start Project
1. Open the terminal application and set the path to the home directory,
   use the command `cd ~/` to move to the home directory.
2. Clone the GitHub repository and use the following commands to change
   the working directory.
   ```commandline
    git init
    git clone https://github.com/bhavesh-asana/airavata-sandbox.git
   ```

# How to run the project

## Server Initialization
1. Before initializing the server, make sure the MongoDB is installed and the instance
   is running locally.
   ```commandline
   mongo --port 27017
   ```
   This command ensure the Mongo instance is running locally and connected the instance to the port 27017.
2. Open a new terminal window (server_runner) and change the directory to the
   server codebase
   ```commandline
   cd ~/airavata-sandbox/gsoc2022/chemData/Server/
   ```
3. Build the Maven project.
   ```commandline
   mvn clean
   mvn package install
   ```
4. Run the Spring Boot application.
   ```commandline
   mvn compile spring-boot:run
   ```
   On successful running of the server application, it shows a message as
   _"Server running successfully"_ and open connection with mongodb driver.

## RPC Handler (Django Application)

Open a new terminal window and follow the steps to run the middleware application.

1. Change the working directory to SMILES middleware.
   ```commandline
   cd ~/airavata-sandbox/gsoc2022/chemData/rpc_handler
   ```
2. Create a virtual environment using the following command. <br/>
   Strictly recommended to use Python version 3.8.3 to build the **grpcio-wheel**.
   ```commandline
   $ conda create -n <EnvironmentName> python=3.8.3
   $ conda activate <EnvironmentName>
   ```
3. Upgrade the PIP version and install the required dependencies using the **requirements.txt** file.
   ```commandline
   pip install -U pip
   pip install -r requirements.txt
   ```
4. Run the Django application.
   ```commandline
   python manage.py runserver
   ```
5. Open http://127.0.0.1:8000/api/molecule/ to check the data transmission from
   the server application. On successful transmission, the data can also be visualized
   in the server terminal.

## Client Initialization

To run the client application, open a new terminal window and follow the below steps

1. Change the working directory to SMILES Dashboard.
   ```commandline
   cd ~/airavata-sandbox/gsoc2022/chemData/data-catalog
   ```
2. Open the new terminal and run the following commands to build the project.
   ```commandline
   yarn install
   yarn run serve
   ```
3. Open
   - http://localhost:8080/ for Login page.
   - http://localhost:8080/home for SEAGrid Homepage.
   - http://localhost:8080/search for the live data catalog.

## Database Management

### Visualize the data with Mongo Compass GUI

The mongo instances are configured in the application.properties file (located
under Server/src/main/resources/). Initialise the mongo compass and connect
to the respective port (27017). On execution of the **ServerApplication**,
the **smiles** database is created and the test data of _calcinfo_ is sent
to the database, which can be viewed under the **calcInfo** collection.

### Visualize with Mongo CLI

To view the data using Mongo shell, open the terminal and follow the commands
mentioned below.

```mongo
 mongo
 show dbs
 use smiles
 show collections
 db.molecule.find().pretty()
```
