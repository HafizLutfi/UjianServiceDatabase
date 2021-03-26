package com.juaracoding.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.main.model.Bonus;
import com.juaracoding.main.model.BonusRowMapper;




@RestController
@RequestMapping("/bonus")
public class BonusController {

	@Autowired
	JdbcTemplate jdbc;
	
	public List<Bonus> getBonus() {

		String sql = "select * from bonus";

		List<Bonus> bonus = jdbc.query(sql, new BonusRowMapper());
		return bonus;
	}
	
	public int insertBonus(Bonus bonus) {
		return jdbc.update("call insert_bonus ("+bonus.getWorker_reff_id()+",'"+bonus.getBonus_date()+"',"+bonus.getBonus_amount()+"");
	}
	
	public int updatebonus(String worker_reff_id, Bonus bonus) {

		return jdbc.update("UPDATE `bonus` SET `bonus_date`='"+bonus.getBonus_date()+"',`bonus_amount`='"+bonus.getBonus_amount()+"' WHERE `worker_reff_id`="+bonus.getWorker_reff_id()+" ");
		
	}
	
	
	public int deleteBonus(String worker_reff_id) {

		return jdbc.update("Delete from bonus where worker_reff_id="+worker_reff_id+"");
	}
	
	
	
	@GetMapping("/")
    public List<Bonus> list() {
        return getBonus();
    }
	
	@PostMapping("/")
	public String add(@RequestBody Bonus bonus) {
	 

		if (this.insertBonus(bonus) == 1) {
			return "Insert data berhasil";
		} else {
			return "Insert data gagal";
		}
    }
	
	@PutMapping("/{worker_reff_id")
    public String update(@RequestBody Bonus bonus, @PathVariable String worker_reff_id) {
		
			if (this.updatebonus(worker_reff_id, bonus) == 1){
				return "Ubah data berhasil";
			} else {
				return "Ubah data gagal";
			}
        
	
 }
	 @DeleteMapping("/{worker_reff_id}")
	    public String delete(@PathVariable String worker_reff_id) {
		 if (this.deleteBonus(worker_reff_id) == 1){
				return "Hapus data berhasil";
			} else {
				return "Hapus data gagal";
			}
	 }	
}
