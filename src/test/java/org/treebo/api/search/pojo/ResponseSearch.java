package org.treebo.api.search.pojo;

import java.util.ArrayList;

public class ResponseSearch {
	private Data data;
	private String status;

	// Getter Methods

	public Data getData() {
		return data;
	}

	public String getStatus() {
		return status;
	}

	// Setter Methods

	public void setData(Data data) {
		this.data = data;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}