package com.revature.dallas_project1.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dallas_project1.model.Reimbursement;
import com.revature.dallas_project1.repo.ReimbursementRepository;
import com.revature.dallas_project1.service.ReimbursementService;

@Service
public class ReimbursementServiceImpl implements ReimbursementService {

	@Autowired
	ReimbursementRepository reimbursementRepository;

	@Override
	public List<Reimbursement> findAll() {
		// TODO Auto-generated method stub
		return reimbursementRepository.findAll();
	}

	@Override
	public Reimbursement findById(int id) {
		// TODO Auto-generated method stub
		return reimbursementRepository.findById(id).get();
	}

	@Override
	public List<Reimbursement> findPending() {
		// TODO Auto-generated method stub
		return reimbursementRepository.findByStatus(1);
	}

	@Override
	public List<Reimbursement> findApproved() {
		// TODO Auto-generated method stub
		return reimbursementRepository.findByStatus(3);
	}

	public Reimbursement updateReimbursementStatus(int id, int status) {
		Reimbursement reimburse = null;
		reimburse = findById(id);
		if (reimburse != null) {
			reimburse.setResolved(new Date());
			reimburse.setStatus(status);
			reimbursementRepository.save(reimburse);
		}
		return reimburse;
	}

	@Override
	public List<Reimbursement> findByAuthor(int id) {
		// TODO Auto-generated method stub
		return reimbursementRepository.findByAuthor(id);
	}
	
	public Reimbursement postReimb(Reimbursement r) {
		
		if (r != null) {
			//r.setId();
			r.setSubmitted(new Date());
            r.setResolved(null);
//            r.setDescription(String description);
//            remb.setAuthor(int author);
            r.setResolver(1);
            r.setStatus(1);
            r.setType(1);
            
            reimbursementRepository.save(r);
		}
		
		return r;
	}
}
