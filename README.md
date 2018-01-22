Steps to run the application:-

1. Deploy the wars in any server

2. If the server is accessed through localhost(both wars are deployed in localhost) then there is no change required.

3. Otherwise, follow the below steps
	3.1 search for "ORIGIN_URL:"https://localhost:8443" in file:- "main.26bdb0b34be6c4da1fad.bundle.js"
	3.2 change the value of ORIGIN_URL to the server IP where "wishlist.war" is deployed
	
	OR
	
	3.1 change the value of "ORIGIN_URL" in "rest-constants.service.ts" in "MakeAWish" project
	3.2 Run mvn install and deploy the war(MakeAWish.war).
	
4. After successful deployment, use the below URL to access the application.
	4.1 https://<hostname>:<port>/MakeAWish
		For example:- https://localhost:8443/MakeAWish
	
P.S. The code is using in-memory database which doesn't require any configuration.

---------------------------------------------------------------------------------------------------------

Please follow below steps if you want to build the source code.

1.) Building MakeAWish 
	1.1) run "npm install" 
	1.2) run "mvn install"

2.) Building wishlist-middleware 
	2.1) run "mvn install"

Thank you!!

