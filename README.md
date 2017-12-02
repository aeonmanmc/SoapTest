# SoapTest

### Soap provider steps:
1. jaxb2-maven-plugin (pom.xml) 
goal - xjc
2. provide xsd file
3. generate Java files
4. config file and controller/ endpoint file

### Soap client steps:
1. generate Java files externally
C:\>wsimport -keep -verbose http://compA.com/ws/server?wsdl
2. marshaller/ unmarshaller file and controller file
