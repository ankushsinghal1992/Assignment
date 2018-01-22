Steps to run the application:-

1. Deploy the wars in any server

2. If the server is accessed through localhost(both wars are deployed in localhost) then there is no change required.

3. Otherwise, follow the below steps
	3.1 search for "ORIGIN_URL:"https://localhost:8443" in file:- "main.2de5af380eeedd876df7.bundle.js"
	3.2 change the value of ORIGIN_URL to the server IP where "wishlist.war" is deployed
	
	OR
	
	3.1 change the value of "ORIGIN_URL" in "rest-constants.service.ts" in "MakeAWish" project
	3.2 Run mvn install and deploy the war(MakeAWish-0.0.1-SNAPSHOT.war).
	
4. After successful deployment, use the below URL to access the application.
	4.1 https://<hostname>:<port>/app
		For example:- https://localhost:8443/app
	
P.S. The code is using in-memory database which doesn't require any configuration.

Thank you!!

