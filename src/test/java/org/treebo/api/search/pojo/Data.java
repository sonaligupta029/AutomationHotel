package org.treebo.api.search.pojo;

import java.util.ArrayList;

public class Data {
	
	private ArrayList<Result> result = new ArrayList<Result>();
	private Sort sort;
	public ArrayList<Result> getResult() {
		return result;
	}
	public void setResult(ArrayList<Result> result) {
		this.result = result;
	}
	public Sort getSort() {
		return sort;
	}
	public void setSort(Sort sort) {
		this.sort = sort;
	}

}
