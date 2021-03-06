package com.albo.marvel.model;

import java.io.Serializable;
import java.util.List;

public class DataEvent implements Serializable {
	
	private static final long serialVersionUID = -1661446814206726694L;
	private Integer offset;
	private Integer limit;
	private Integer total;
	private Integer count;
	private List<ResultEvent> results;
	
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<ResultEvent> getResults() {
		return results;
	}
	public void setResults(List<ResultEvent> results) {
		this.results = results;
	}




}