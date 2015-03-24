** Building and Deploying a Custom Jetspeed Portal **
mvn jetspeed:mvn -Dtarget=all

> Build Commands for Maven-2 and Jetspeed


<table>
	<th>
		<td>Command</td>
		<td>Description</td>
	</th>
    <tr>
        <td>mvn jetspeed:mvn -Dtarget=install-pa</td>
        <td>Cleans and builds the portlet application subproject.</td>
    </tr>
    <tr>
        <td>mvn jetspeed:mvn -Dtarget=install-portal</td>
        <td>Cleans and builds the portal application subproject</td>
    </tr>
    <tr>
        <td>mvn jetspeed:mvn -Dtarget=install</td>
        <td>Does `install-pa' and `install-portal'.	</td>
    </tr>
    <tr>
        <td>mvn jetspeed:mvn -Dtarget=db</td>
        <td>Initializes the database and seed the initial data for your custom portal.</td>
    </tr>
    <tr>
        <td>mvn jetspeed:mvn -Dtarget=portal-seed</td>
        <td>Just seeds the initial data for your custom portal without initializing the database.</td>
    </tr>
    <tr>
        <td>mvn jetspeed:mvn -Dtarget=deploy-pa</td>
        <td>Deploys your custom portlet application.</td>
    </tr>
    <tr>
        <td>mvn jetspeed:mvn -Dtarget=deploy-portal</td>
        <td>Deploys your custom portal.</td>
    </tr>
    <tr>
        <td>mvn jetspeed:mvn -Dtarget=portal-seed-dbpsml</td>
        <td>Seeds database-based pages data for your custom portal application.</td>
    </tr>
    <tr>
        <td>mvn jetspeed:mvn -Dtarget=deploy-portal-dbpsml</td>
        <td>Deploys your custom portal with seeding database-based pages data.</td>
    </tr>
    <tr>
        <td>mvn jetspeed:mvn -Dtarget=all</td>
        <td>Installs and deploys your custom portal and custom portlet application, initializes and seeds the database.</td>
    </tr>    
</table>

** Markdown Syntax **
http://wowubuntu.com/markdown/

** Maven setting **
settings.xml 
<settings xmlns="http://maven.apache.org/POM/4.0.0"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
       http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <pluginGroups>
    <pluginGroup>org.apache.portals.jetspeed-2</pluginGroup>
  </pluginGroups>       
</settings>
