# Java Dictionary RMI Client
###### *Dillon Ward - G00326756 - Distributed Systems*
---

## Introduction
The following repository contains a Java RMI Server Dictionary Application Client for a fourth-year undergraduate project for the module Distributed Systems. The module is taught to undergraduate students at GMIT in the Department of Computer Science and Applied Physics. The lecturer is Patrick Mannion.

## Cloning this Repository
To clone this repository and run the solutions, do the following:

```
In the command line change to a directory:
cd <directory>

Clone the repository:
git clone https://github.com/DillonWard/Java-Dictionary-RMI-Client.git

Change directory into the cloned folder:
cd <folder name>

Run the server:
java -jar dictionary-service.jar

Unpack the .war file:
cd <C:\Tomcat\webapps>
copy and paste the 'RMI-Dictionary-Service.war' file into the 'webapps' folder

Start Tomcat:
cd into the <C:\Tomcat\bin> directory and run 'startup'

The webapp should be running at 'localhost:8080/RMI-Dictionary-Service/'
```

## Architecture
### Client
#### ContentServlet
The ContentServlet is the Backend for the JSP file. It handles all data being passed to and from the JSP. The ContentServlet has 2 funtionalitites, `doPost` and `doGet`.

The `doPost` takes in the parameter that is being passed from the JSP input box and creates a thread for it to be added to a queue for execution. Initially, if the queue is empty a new thread will be created and the word is passed in. Otherwise, the word will be added to a queue. After the thread is created, it is put to sleep for 10 seconds and a `poll` is done to get the head of the queue.

The `doGet` is responsible for simply redirecting to the servley and returning the response from the server to the JSP servlet.

#### DictionaryClient
The DictionaryClient contains a default constructor which is used for adding to a queue, a `run`,`append` and `pollQueue` method.

The `run` method is responsible for handling the queues and doing the `Naming.lookup` to get the response from the server. Then, the response is passed to the `checkWord` function in the server. The response or definition from the server is then added to a response queue and returned to the JSP.

The `append` method is used for adding new words to the queue and running the `run` method so that the queue is executed.

The `pollQueue` is responsible for returning the head of the queue to the JSP.

### Server
#### DictionaryServer
The DictionaryServer is where the `main` method for the server is located. This is responsible for binding the remote object to the RMI registry so it can be implemented on the client side. It creates a registry at port `1099` which is the default port for RMI and uses `Naming.rebind` to assign a name to the service so that it can be used in the `Naming.lookup` service.

#### DictionaryService
This is the remote interface that contains our `checkWord` function that will be implemented by the Client. The remote interface `extends Remote`.

#### DictionaryServiceImpl
This class contains a constructor that takes in the `file name` from the server. The name of the dictionary is passed in from the server and set here.

The `checkWord` class is implemented from the Remote Interface. First, it calls the `readFile` function which will populate a HashaMap with a dictionary. The word from the JSP is passed into this function and the dictionary HashMap is checked to see if there's a key associated with that word. If there is, the value linked to the key is returned in a response. Otherwise, "no word found" is returned.

Finally, the `readFile` is responsible for reading in our `dictionary.txt` file. The file is read in and is split where there is a ':' into a Key: value HashMap.