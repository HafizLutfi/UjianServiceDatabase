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


import com.juaracoding.main.model.Worker;
import com.juaracoding.main.model.WorkerRowMapper;


@RestController
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	JdbcTemplate jdbc;
	
	public List<Worker> getWorker() {

		String sql = "select * from worker";

		List<Worker> worker = jdbc.query(sql, new WorkerRowMapper());
		return worker;
	}
	
	public int insertWorker(Worker worker) {
		return jdbc.update("call insert_worker ("+worker.getWorker_id()+",'"+worker.getFirst_name()+"','"+worker.getLast_name()+"',"+worker.getSalary()+",'"+worker.getJoining_date()+"','"+worker.getDepartment()+"')");
	}
	
	public int updateWorker(String worker_id, Worker worker) {

		return jdbc.update("UPDATE `worker` SET `first_name`='"+worker.getFirst_name()+"',`last_name`='"+worker.getLast_name()+"',`salary`="+worker.getSalary()+",`joining_date`='"+worker.getJoining_date()+"',`department`='"+worker.getDepartment()+"' WHERE `worker_id`="+worker.getWorker_id()+" ");
		
	}
	
	
	public int deleteWorker(int worker_id) {

		return jdbc.update("Delete from worker where worker_id="+worker_id+"");
	}
	
	
	
	@GetMapping("/")
    public List<Worker> list() {
        return getWorker();
    }
	
	@PostMapping("/")
	public String add(@RequestBody Worker worker) {
	 

		if (this.insertWorker(worker) == 1) {
			return "Insert data berhasil";
		} else {
			return "Insert data gagal";
		}
    }
	
	@PutMapping("/{worker_id}")
    public String update(@RequestBody Worker worker, @PathVariable String worker_id) {
		
			if (this.updateWorker(worker_id, worker) == 1){
				return "Ubah data berhasil";
			} else {
				return "Ubah data gagal";
			}
        
	
 }
	 @DeleteMapping("/{worker_id}")
	    public String delete(@PathVariable int worker_id) {
		 if (this.deleteWorker(worker_id) == 1){
				return "Hapus data berhasil";
			} else {
				return "Hapus data gagal";
			}
	 }	
	 @GetMapping("/top")
	 public List<Worker> lstTop() {

			String sql = "call topSalary";

			List<Worker> salary = jdbc.query(sql, new WorkerRowMapper());
			return salary;
		}
	 
	 @GetMapping("/sama")
	 public List<Worker> lstsama() {

			String sql = "SELECT * FROM worker WHERE Salary IN (SELECT Salary FROM worker GROUP BY Salary HAVING COUNT(*) > 1)";

			List<Worker> sama = jdbc.query(sql, new WorkerRowMapper());
			return sama;
		}
	 
	 
	 @GetMapping("/dept")
	 public List<Worker> lstdept() {

			String sql = "Select department, COUNT(*)as jumlah from worker GROUP BY department";

			List<Worker> dept = jdbc.query(sql, new WorkerRowMapper());
			return dept;
		}
}
