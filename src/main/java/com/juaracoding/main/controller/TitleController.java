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

import com.juaracoding.main.model.Title;
import com.juaracoding.main.model.TitleRowMapper;



@RestController
@RequestMapping("/title")
public class TitleController {

	@Autowired
	JdbcTemplate jdbc;
	
	public List<Title> getTitle() {

		String sql = "select * from title";

		List<Title> title = jdbc.query(sql, new TitleRowMapper());
		return title;
	}
	
	public int insertTitle(Title title) {
		return jdbc.update("call insert_title ("+title.getWorker_reff_id()+",'"+title.getWorker_title()+"','"+title.getAffected_from()+"'");
	}
	
	public int updateTitle(String worker_reff_id, Title title) {

		return jdbc.update("UPDATE `title` SET `worker_title`='"+title.getWorker_title()+"',`affected_from`='"+title.getAffected_from()+"' WHERE `worker_reff_id`="+title.getWorker_reff_id()+" ");
		
	}
	
	
	public int deleteTitle(String worker_reff_id) {

		return jdbc.update("Delete from title where worker_reff_id="+worker_reff_id+"");
	}
	
	
	
	@GetMapping("/")
    public List<Title> list() {
        return getTitle();
    }
	
	@PostMapping("/")
	public String add(@RequestBody Title title) {
	 

		if (this.insertTitle(title) == 1) {
			return "Insert data berhasil";
		} else {
			return "Insert data gagal";
		}
    }
	
	@PutMapping("/{worker_reff_id")
    public String update(@RequestBody Title title, @PathVariable String worker_reff_id) {
		
			if (this.updateTitle(worker_reff_id, title) == 1){
				return "Ubah data berhasil";
			} else {
				return "Ubah data gagal";
			}
        
	
 }
	 @DeleteMapping("/{worker_reff_id}")
	    public String delete(@PathVariable String worker_reff_id) {
		 if (this.deleteTitle(worker_reff_id) == 1){
				return "Hapus data berhasil";
			} else {
				return "Hapus data gagal";
			}
	 }	
}
