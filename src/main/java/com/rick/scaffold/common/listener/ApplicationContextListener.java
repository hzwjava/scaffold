package com.rick.scaffold.common.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.rick.scaffold.common.search.SearchService;

@Component
public class ApplicationContextListener implements
		ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext applicationContext = event.getApplicationContext();
		//init search service after applicationContext being loaded
		SearchService searchService = (SearchService) applicationContext
				.getBean("userSearchService");
		searchService.initService();

	}

}
