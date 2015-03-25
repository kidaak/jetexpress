package org.apache.portals.tutorials;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.jetspeed.CommonPortletServices;
import org.apache.jetspeed.administration.PortalAdministration;
import org.apache.jetspeed.components.portletregistry.PortletRegistry;
import org.apache.jetspeed.page.PageManager;
import org.apache.jetspeed.security.GroupManager;
import org.apache.jetspeed.security.RoleManager;
import org.apache.jetspeed.security.UserManager;

import org.apache.commons.lang.StringUtils;

public class JetspeedServicesPortlet extends GenericPortlet {
	private PortalAdministration admin;
	private PageManager pageManager;
	private RoleManager roleManager;
	private UserManager userManager;
	private GroupManager groupManager;
	protected PortletRegistry registry;

	private List registrationRoles;
	private List registrationGroups;
	private List newRoles;
	private List newGroups;
	private List newUsers;

	@Override
	public void init(PortletConfig config) throws PortletException {
		super.init(config);
		admin = (PortalAdministration) getPortletContext().getAttribute(CommonPortletServices.CPS_PORTAL_ADMINISTRATION);
		if (null == admin) {
			throw new PortletException("Failed to find the Portal Administration on portlet initialization");
		}
		userManager = (UserManager) getPortletContext().getAttribute(CommonPortletServices.CPS_USER_MANAGER_COMPONENT);
		if (null == userManager) {
			throw new PortletException("Failed to find the User Manager on portlet initialization");
		}
		roleManager = (RoleManager) getPortletContext().getAttribute(CommonPortletServices.CPS_ROLE_MANAGER_COMPONENT);
		if (null == roleManager) {
			throw new PortletException("Failed to find the Role Manager on portlet initialization");
		}
		groupManager = (GroupManager) getPortletContext().getAttribute(CommonPortletServices.CPS_GROUP_MANAGER_COMPONENT);
		if (null == groupManager) {
			throw new PortletException("Failed to find the Group Manager on portlet initialization");
		}
		pageManager = (PageManager) getPortletContext().getAttribute(CommonPortletServices.CPS_PAGE_MANAGER_COMPONENT);
		if (null == pageManager) {
			throw new PortletException("Failed to find the Page Manager on portlet initialization");
		}
		registry = (PortletRegistry) getPortletContext().getAttribute(CommonPortletServices.CPS_REGISTRY_COMPONENT);
		if (null == registry) {
			throw new PortletException("Failed to find the Portlet Registry on portlet initialization");
		}
		this.newRoles = getInitParameterList(config, "roles");
		this.newGroups = getInitParameterList(config, "groups");
		this.newUsers = getInitParameterList(config, "users");
		this.registrationRoles = getInitParameterList(config, "registration-roles");
		this.registrationGroups = getInitParameterList(config, "registration-groups");

	}

	protected List getInitParameterList(PortletConfig config, String ipName) {
		String temp = config.getInitParameter(ipName);
		if (temp == null)
			return new ArrayList();

		String[] temps = temp.split("\\,");
		for (int ix = 0; ix < temps.length; ix++)
			temps[ix] = temps[ix].trim();

		return Arrays.asList(temps);
	}

	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		request.setAttribute("message", request.getParameter("message"));
		request.setAttribute("errorMessage", request.getParameter("errorMessage"));
		super.doView(request, response);
	}

	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		String action = request.getParameter("action");
		try {
			if (action != null) {
				if (action.equals("createRoles")) {
					String message = "Created " + createRoles() + " roles";
					response.setRenderParameter("message", message);
				} else if (action.equals("createGroups")) {
					String message = "Created " + createGroups() + " groups";
					response.setRenderParameter("message", message);
				} else if (action.equals("registerUsers")) {
					String message = "Registered " + registerUsers() + " users";
					response.setRenderParameter("message", message);
				} else if (action.equals("modifyPages")) {
					String message = "Modified " + modifyPages() + " pages";
					response.setRenderParameter("message", message);
				} else if (action.equals("createSharedPages")) {
					String message = "Created " + createSharedPages() + " pages";
					response.setRenderParameter("message", message);
				}
			}
		} catch (Exception e) {
			response.setRenderParameter("serviceError", e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * create a folder named /shared, create a page name /friends.psml. add some
	 * portlets to the page. grant public-view security constraint to the folder
	 * 
	 * @return
	 */
	private String createSharedPages() {
		return StringUtils.join(newRoles, ",");
	}

	/**
	 * using the users init param, modify pages with the PageManager service. If
	 * the page doesnt exist, dont create it. Modifications: for user1, create a
	 * 1 column collection of 1 portlet, for user2, create a 2 column collection
	 * of 2 portlets, for user3 create a 3 column collection of 3 portets
	 * 
	 * @return
	 */
	private String modifyPages() {
		return StringUtils.join(newRoles, ",");
	}

	/**
	 * using the users init param, register new users with the
	 * PortalAdministration service. If the user already exists, skip it.
	 * 
	 * @return
	 */
	private String registerUsers() {
		return StringUtils.join(newUsers, ",");
	}

	/**
	 * using the groups init param, create new groups with the GroupManager
	 * service. If the group already exists, skip it.
	 * 
	 * @return
	 */
	private String createGroups() {
		return StringUtils.join(newGroups, ",");
	}

	/**
	 * using the roles init param, create new roles with the RoleManager
	 * service. If the role already exists, skip it.
	 * 
	 * @return
	 */
	private String createRoles() {
		return StringUtils.join(newRoles, ",");
	}
}
