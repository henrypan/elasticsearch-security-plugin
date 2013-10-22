package org.elasticsearch.plugins.security;

import java.util.Collection;

import org.elasticsearch.common.collect.Lists;
import org.elasticsearch.common.component.LifecycleComponent;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.plugins.security.service.SecurityService;

public class SecurityPlugin extends AbstractPlugin {

	private final ESLogger log = Loggers.getLogger(getClass());

	public SecurityPlugin() {
		log.debug("Starting Security Plugin");		
	}

	// for Service
	@SuppressWarnings("rawtypes")
	@Override
	public Collection<Class<? extends LifecycleComponent>> services() {
		final Collection<Class<? extends LifecycleComponent>> services = Lists
				.newArrayList();
		services.add(SecurityService.class);
		return services;
	}


	public String description() {
		return "Security Plugin";
	}

	public String name() {
		return "elasticsearch-security-plugin";
	}

}
