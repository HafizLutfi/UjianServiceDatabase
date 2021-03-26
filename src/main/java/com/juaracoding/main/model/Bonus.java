package com.juaracoding.main.model;

public class Bonus {

		private int worker_reff_id;
		private String bonus_date;
		private int bonus_amount;
		
		
	public Bonus() {
		
	}
	
		public Bonus(int worker_reff_id, String bonus_date, int bonus_amount) {
			super();
			this.worker_reff_id = worker_reff_id;
			this.bonus_date = bonus_date;
			this.bonus_amount = bonus_amount;
		}
		public int getWorker_reff_id() {
			return worker_reff_id;
		}
		public void setWorker_reff_id(int worker_reff_id) {
			this.worker_reff_id = worker_reff_id;
		}
		public String getBonus_date() {
			return bonus_date;
		}
		public void setBonus_date(String bonus_date) {
			this.bonus_date = bonus_date;
		}
		public int getBonus_amount() {
			return bonus_amount;
		}
		public void setBonus_amount(int bonus_amount) {
			this.bonus_amount = bonus_amount;
		}
		
		
}
