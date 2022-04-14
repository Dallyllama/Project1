package com.revature.dallas_project1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.dallas_project1.model.Reimbursement;

public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer> {

	public List<Reimbursement> findByStatus(int statusId);
	
	public List<Reimbursement> findByAuthor(int authorId);

}
