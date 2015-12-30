package com.rick.scaffold.soa.search.service;

import com.rick.scaffold.soa.search.SearchKeywords;

public interface ProductSearch {

	void importFromDB(String sql) throws Exception;
	
	SearchKeywords searchForKeywords(String index, String type, String jsonString, int entriesCount);
}