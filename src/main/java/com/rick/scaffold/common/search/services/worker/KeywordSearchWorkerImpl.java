package com.rick.scaffold.common.search.services.worker;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.rick.scaffold.common.search.services.RZSearchResponse;
import com.rick.scaffold.common.search.services.delegate.SearchDelegate;
import com.rick.scaffold.common.search.utils.SearchClient;

public class KeywordSearchWorkerImpl implements KeywordSearchWorker {

	@Autowired
	private SearchDelegate searchDelegate;

	public RZSearchResponse execute(SearchClient client, String index,
			String json, int size, ExecutionContext context) throws Exception {

		Collection<String> hits = searchDelegate.searchAutoComplete(index,
				json, size);
		RZSearchResponse resp = new RZSearchResponse();

		String[] array = (String[]) hits.toArray(new String[hits.size()]);

		resp.setInlineSearchList(array);
		if (array.length > 0) {
			resp.setCount(array.length);
		}

		return resp;

	}

}