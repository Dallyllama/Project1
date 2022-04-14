package com.revature.dallas_project1.service;

import java.util.List;

import com.revature.dallas_project1.model.Reimbursement;

public interface ReimbursementService {

	public List<Reimbursement> findAll();

	public Reimbursement findById(int id);

	public List<Reimbursement> findPending();

	public List<Reimbursement> findApproved();

	public Reimbursement updateReimbursementStatus(int id,int status);
	
	public Reimbursement postReimb(Reimbursement r);
	
	public List<Reimbursement> findByAuthor(int id);

}
