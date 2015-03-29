** Tomcat **
conf/tomcat-users.xml
<tomcat-users>
	<role rolename="manager-gui"/>
	<role rolename="manager-script"/>
	<role rolename="manager-jmx"/>
	<role rolename="manager-status"/>
	<role rolename="admin-script"/>

	<role rolename="admin"/>
	<role rolename="manager"/>
	<role rolename="tomcat"/>
	
	<user password="admin" roles="manager-gui,manager-script,manager-jmx,manager-status,admin-script" username="admin"/>
	<user username="j2deployer" password="j2deployer" roles="admin,manager,tomcat"/>
	<user name="tomcat" password="tomcat" roles="tomcat" />
</tomcat-users>

** Building and Deploying a Custom Jetspeed Portal **	
mvn jetspeed:mvn -Dtarget=all

mvn jetspeed:mvn -Dtarget=deploy-pa
mvn jetspeed:mvn -Dtarget=deploy-portal
mvn jetspeed:mvn -Dtarget=deploy-petportal
mvn jetspeed:mvn -Dtarget=deploy-all -X > deploy-all.log 

mvn archetype:generate -DgroupId=org.springframework.samples.petportal -DartifactId=petportal -DarchetypeArtifactId=maven-archetype-webapp

grep -rn 'words' *

> Build Commands for Maven-2 and Jetspeed


<table>
	<tr>
		<td>Command</td>
		<td>Description</td>
	</tr>
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

** Building and Deploying Jetspeed 2.2 from Source with Maven-2 **	
http://portals.apache.org/jetspeed-2/buildguide/maven-2-build.html

** A short overview of Jetspeed features: **	
>*New* 2.2.2 Portlet Cloning: allow site editors to quickly create new portlet variants based on modified preference and other descriptor settings
>*New* 2.2.2 Admin roles security restriction on admin roles maintenance
>*New* 2.2.1 JetUI AJAX Customization Engine with Dockable Toolbox, Drag and Drop, New Navigations
>Secure Access - Security based on standards, ACLs, Open ID, CAS
>Single Point of Entry (SSO, Federated)
>Enterprise Integration - (EAI, integration points)
>Personalization - (customizers, skins)
>Dynamic Web Components - (portlets based on standards)
>Scaleable, Component Architecture featuring multi-threading


** Apache 门户项目组介绍 **	
http://www.ibm.com/developerworks/cn/opensource/os-apache-portal/
<table>
	<tr>
		<td>名词</td>
		<td>解释</td>
	</tr>
	<tr>
		<td>Portal</td>
		<td>门户，提供包括内容聚合、单点登陆、个性化定制和安全管理等服务的基础Web平台。</td>
	</tr>	
	<tr>
		<td>Portlet</td>
		<td>Portlet是基于web的Java组件。它由Portlet容器管理，能够处理请求，产生动态内容。Portlet被Portal用作为可插拔的用户接口组件，为信息系统提供展现。由Portlet动态产生的内容也被叫做fragment。fragment是遵循某种规则的标记（例如：HTML， XHTML，WML），可与其他的fragment一起建立一个完整的文档。一般一个Portlet产生的内容和其他的Portlet产生的内容聚集在一起形成Portal网页。</td>
	</tr>	
	<tr>
		<td>Portlet Container</td>
		<td>Portlet在Portlet容器中运行，Portlet容器为Portlet提供必需的运行环境。Portlet容器包含Portlet（组件）并且管理它们的生命周期，它也为Portlet的参数设置提供持久化的存储。Portlet 容器不是一个类似于 servlet 容器的独立容器。它是在 servlet 容器上通过扩展方式实现的，并重用 servlet容器提供的功能。从Portal的角度来看，Portlet Container是Portal平台所提供的众多服务之一。</td>
	</tr>	
	<tr>
		<td>JSR168，JSR286</td>
		<td>由于越来越多的公司开发了各自的Portal组件和基于其的Portal产品(如Bea, IBM, Oracle, Sun, Sybase, Novell, SAP, Jetspeed, Vignette 等.这种互不兼容的接口实现不断带给程序提供商各种问题和麻烦, 为了解决这种问题, JCP发布了JSR168 (Java Specification Request), Portlet Specification, 用以提供不同Portal和Portlets之间的互用性。JSR 286是168规范的延伸，是目前最新标准规范，目前仍处在draft状态。</td>
	</tr>	
	<tr>
		<td>SSO Single</td>
		<td>Sign-On，即单点登陆。当一个大系统中存在多个子系统时，用户只需要正确登陆其中任何一个子系统，就可以在各个子系统中来回自由切换和使用授予该用户权限的各种资源。一般可以分为两种类型：Web应用之间的单点登陆和门户Web应用和它所连接的后台系统之间的单点登陆。SSO是任何一个门户产品必须解决的问题，必须提供的服务。</td>
	</tr>	
	<tr>
		<td>WSRP</td>
		<td>WSRP是OASIS组织的一个规范，它定义了远程门户网站的Web服务。通过Web Service将远程内容抓取到本地，最后通过本地内容聚合引擎展示出来。</td>
	</tr>				
<table>	


** Maven command **
mvn dependency:sources
mvn dependency:resolve -Dclassifier=javadoc

** Jetspeed link **
http://portals.apache.org/jetspeed-2/
http://portals.apache.org/jetspeed-2/getting-started.html
http://portals.apache.org/jetspeed-2/buildguide/jetspeed-maven-plugins.html
https://portals.apache.org/jetspeed-2/buildguide/project-layout.html
http://portals.apache.org/jetspeed-2/buildguide/jetspeed-archetype.html
http://www.ibm.com/developerworks/cn/opensource/os-apache-portal/
https://www.jcp.org/en/jsr/detail?id=168
https://www.jcp.org/en/jsr/detail?id=286
http://portals.apache.org/bridges/
http://www.oopsconsultancy.com/software/xmltask/

 > defineObjects
<portlet:defineObjects/>
<table>
	<tr>
		<td>renderRequest</td>
		<td></td>
	</tr>
	<tr>
		<td>renderResponse</td>
		<td></td>
	</tr>
	<tr>
		<td>portletConfig</td>
		<td></td>
	</tr>
</table>

** Jetspeed startup **
org.apache.jetspeed.engine.JetspeedServlet.init(ServletConfig)
    public final void init( ServletConfig config ) throws ServletException{
        synchronized (this.getClass()){

                ServletContext context = config.getServletContext();

                String propertiesFilename = ServletHelper.findInitParameter(context, config, JETSPEED_PROPERTIES_KEY,
                        JETSPEED_PROPERTIES_DEFAULT);

                String applicationRoot = ServletHelper.findInitParameter(context, config, APPLICATION_ROOT_KEY,
                        APPLICATION_ROOT_DEFAULT);

                webappRoot = config.getServletContext().getRealPath("/");

                if (applicationRoot == null || applicationRoot.equals(WEB_CONTEXT)){
                    applicationRoot = webappRoot;
                }

                applicationRoot = applicationRoot.replace('\\', '/');
                
                PropertiesConfiguration properties = new PropertiesConfiguration();
                File propsFile = new File(ServletHelper.getRealPath(config, propertiesFilename));
                if (!propsFile.isFile()){
                    throw new IOException("Jetspeed properties not found: "+propsFile.getAbsolutePath());
                }
                File jetspeedPropertiesPath = propsFile.getParentFile();
                properties.load(propsFile);
                propsFile = new File(jetspeedPropertiesPath,OVERRIDE_PROPERTIES);
                if (propsFile.exists()){
                    PropertiesConfiguration extraProps = new PropertiesConfiguration();
                    extraProps.load(propsFile);
                    ConfigurationUtils.copy(extraProps,properties);
                }
                propsFile = new File(jetspeedPropertiesPath,SPRING_FILTER_KEY_PROPERTIES);
                if (propsFile.exists()){
                    PropertiesConfiguration extraProps = new PropertiesConfiguration();
                    extraProps.load(propsFile);
                    Object springFilterKey = extraProps.getProperty(SPRING_FILTER_KEY);
                    if (springFilterKey != null){
                        properties.setProperty(SPRING_FILTER_KEY, springFilterKey);
                    }
                }
                properties.setProperty(APPLICATION_ROOT_KEY, applicationRoot);
                properties.setProperty(WEBAPP_ROOT_KEY, webappRoot);
                properties.setProperty(JETSPEED_PROPERTIES_PATH_KEY, jetspeedPropertiesPath.getAbsolutePath());

                engine = new JetspeedEngine(properties, applicationRoot, config, initializeComponentManager(config, applicationRoot, properties));
                Jetspeed.setEngine(engine);
                engine.start();                
                contextComponent = (RequestContextComponent) Jetspeed.getComponentManager().getComponent(RequestContextComponent.class);
        }
    }
org.apache.jetspeed.engine.JetspeedServlet.init(HttpServletRequest, HttpServletResponse)
    public final void init( HttpServletRequest request, HttpServletResponse response )
    {
        synchronized (JetspeedServlet.class)
        {
            if (firstDoGet)
            {
                // initialize the Portal context path
                engine.getContext().setContextPath(request.getContextPath());
                // Mark that we're done.
                firstDoGet = false;
            }
        }
    }
    
org.apache.jetspeed.engine.JetspeedServlet.initializeComponentManager(ServletConfig, String, Configuration)
    protected ComponentManager initializeComponentManager(ServletConfig servletConfig, String appRoot, Configuration configuration) throws IOException {
        ServletConfigFactoryBean.setServletConfig(servletConfig);
        final String assemblyDir = configuration.getString("assembly.dir","/WEB-INF/assembly");
        final String assemblyFileExtension = configuration.getString("assembly.extension",".xml");
        String springFilterKey = configuration.getString(SPRING_FILTER_KEY, SPRING_FILTER_KEY_DEFAULT);
        File springFilterProperties = new File(configuration.getString(JETSPEED_PROPERTIES_PATH_KEY), SPRING_FILTER_PROPERTIES);
        if (!springFilterProperties.isFile()){
            throw new IOException("Spring filter properties not found: "+springFilterProperties.getAbsolutePath());
        }
        String[] bootConfigs = new String[] {"/WEB-INF/assembly/boot/*.xml"};
        String[] appConfigs =  new String[] {assemblyDir+"/*"+assemblyFileExtension, assemblyDir+"/override/*"+assemblyFileExtension};
        ServletContext servletContext = servletConfig.getServletContext();
        JetspeedBeanDefinitionFilter filter = new JetspeedBeanDefinitionFilter("file:"+springFilterProperties.getAbsolutePath(), springFilterKey);
        Properties initProperties = new Properties();
        initProperties.put(JETSPEED_PROPERTIES_PATH_KEY, configuration.getString(JETSPEED_PROPERTIES_PATH_KEY));
        SpringComponentManager cm = new SpringComponentManager(filter, bootConfigs, appConfigs, servletContext, appRoot, initProperties);      
        
        return cm;        
    }    
org.apache.jetspeed.components.SpringComponentManager.SpringComponentManager(JetspeedBeanDefinitionFilter, String[], String[], ServletContext, String, Properties)
    public SpringComponentManager(JetspeedBeanDefinitionFilter filter, String[] bootConfigs, String[] appConfigs, ServletContext servletContext,
            String appRoot, Properties initProperties){

        appRoot = appRoot.replace('\\', '/');
        
        if (initProperties == null){
            initProperties = new Properties();
        }
        initProperties.setProperty(JetspeedEngineConstants.APPLICATION_ROOT_KEY, appRoot);
        if (!initProperties.containsKey(JetspeedEngineConstants.JETSPEED_PROPERTIES_PATH_KEY)){
            initProperties.put(JetspeedEngineConstants.JETSPEED_PROPERTIES_PATH_KEY, appRoot+JetspeedEngineConstants.JETSPEED_PROPERTIES_PATH_DEFAULT);
        }
        
        if (bootConfigs != null && bootConfigs.length > 0){
            bootCtx = new FilteringXmlWebApplicationContext(filter, bootConfigs, initProperties, servletContext);
        }
        else{
            bootCtx = new FileSystemXmlApplicationContext();
        }
        appContext = new FilteringXmlWebApplicationContext(filter, appConfigs, initProperties, servletContext, bootCtx);

        factories = new ArrayList();
        factories.add(appContext);

        servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, appContext);
    }
org.apache.jetspeed.components.FilteringXmlWebApplicationContext.FilteringXmlWebApplicationContext(JetspeedBeanDefinitionFilter, String[], Properties, ServletContext, ApplicationContext)
    public FilteringXmlWebApplicationContext(JetspeedBeanDefinitionFilter filter, String[] configLocations, Properties initProperties, ServletContext servletContext, ApplicationContext parent)
    {
        super();
        if (parent != null){
            this.setParent(parent);
        }
        if (initProperties != null){
            PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
            ppc.setIgnoreUnresolvablePlaceholders(true);
            ppc.setSystemPropertiesMode(PropertyPlaceholderConfigurer.SYSTEM_PROPERTIES_MODE_FALLBACK);
            ppc.setProperties(initProperties);
            addBeanFactoryPostProcessor(ppc);
        }
        setConfigLocations(configLocations);
        setServletContext(servletContext);
        this.filter = filter;
    }    
    
    