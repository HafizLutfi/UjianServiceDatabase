package com.juaracoding.main.model;

public class Title {

	private int worker_reff_id;
	private String worker_title;
	private String affected_from;
	
	public Title() {
		
	}
	
	
	public Title(int worker_reff_id, String worker_title, String affected_from) {
		super();
		this.worker_reff_id = worker_reff_id;
		this.worker_title = worker_title;
		this.affected_from = affected_from;
	}
	public int getWorker_reff_id() {
		return worker_reff_id;
	}
	public void setWorker_reff_id(int worker_reff_id) {
		this.worker_reff_id = worker_reff_id;
	}
	public String getWorker_title() {
		return worker_title;
	}
	public void setWorker_title(String worker_title) {
		this.worker_title = worker_title;
	}
	public String getAffected_from() {
		return affected_from;
	}
	public void setAffected_from(String affected_from) {
		this.affected_from = affected_from;
	}
	
	
}
