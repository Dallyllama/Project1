package com.revature.dallas_project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dallas_project1.model.Reimbursement;
import com.revature.dallas_project1.service.ReimbursementService;

@RestController
public class ReimbursementController {
	@Autowired
	ReimbursementService reimbursementService;

	@GetMapping("/reimbursement")
	public List<Reimbursement> getAllReimbursement() {
		return reimbursementService.findAll();
	}
	
	
	@GetMapping("/reimbursement/{id}")
	public Reimbursement getReimbursementById(@PathVariable int id) {
		return reimbursementService.findById(id);
	}
	
	@PutMapping("/reimbursement/{id}")
	public Reimbursement updateReimbursement(@PathVariable int id, @RequestBody int status) {
		return reimbursementService.updateReimbursementStatus(id, status);
	}
	
	@GetMapping("/users/{authorId}/reimbursement")
	public List<Reimbursement> getReimbursementByUser(@PathVariable int authorId) {
		return reimbursementService.findByAuthor(authorId);
	}
	
	@PostMapping("/reimbursement")
	public Reimbursement addReimbursement(Reimbursement r) {
		
		return reimbursementService.postReimb(r);
	}
}
