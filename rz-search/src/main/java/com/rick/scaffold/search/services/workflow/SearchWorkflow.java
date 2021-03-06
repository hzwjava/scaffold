package com.rick.scaffold.search.services.workflow;

import java.util.List;

import com.rick.scaffold.search.SearchConstants;
import com.rick.scaffold.search.services.RZSearchRequest;
import com.rick.scaffold.search.services.RZSearchResponse;
import com.rick.scaffold.search.services.worker.KeywordSearchWorker;
import com.rick.scaffold.search.services.worker.SearchWorker;

public class SearchWorkflow extends Workflow {

	private List<SearchWorker> searchFlow;
	private List<KeywordSearchWorker> searchKeywordWorkflow;

	public List<KeywordSearchWorker> getSearchKeywordWorkflow() {
		return searchKeywordWorkflow;
	}

	public void setSearchKeywordWorkflow(List<KeywordSearchWorker> searchKeywordWorkflow) {
		this.searchKeywordWorkflow = searchKeywordWorkflow;
	}
	
	public List<SearchWorker> getSearchFlow() {
		return searchFlow;
	}

	public void setSearchFlow(List<SearchWorker> searchFlow) {
		this.searchFlow = searchFlow;
	}

	public RZSearchResponse searchAutoComplete(String index, String json, String type,
			int size) throws Exception {
		RZSearchResponse response = null;
		if (searchKeywordWorkflow != null) {
            String keywordType = SearchConstants.KEYWORD + "_" + type;
			for (KeywordSearchWorker sw : searchKeywordWorkflow) {
				response = sw.execute(super.getSearchClient(), index, json,
                        keywordType, size);
			}
		}
		return response;
	}

	public RZSearchResponse search(RZSearchRequest request) throws Exception {
		RZSearchResponse response = null;
		if (searchFlow != null) {
			for (SearchWorker sw : searchFlow) {
				response = sw.execute(super.getSearchClient(), request);
			}
		}
		return response;
	}
}
