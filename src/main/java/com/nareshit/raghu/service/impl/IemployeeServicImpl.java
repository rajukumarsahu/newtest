package com.nareshit.raghu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.raghu.entity.EmployeeEntity;
import com.nareshit.raghu.repositery.EmpliyeeRepositery;
import com.nareshit.raghu.service.IEmployeeService;
@Service
public class IemployeeServicImpl implements IEmployeeService {

	    @Autowired
		private EmpliyeeRepositery repo;
		@Override
		public Integer saveEmployee(EmployeeEntity e) {
			// TODO Auto-generated method stub
			return repo.save(e).getEmpid();
		}

		@Override
		public void updateEmployee(EmployeeEntity e) {
			// TODO Auto-generated method stub
				repo.save(e);
		}

		@Override
		public void deleteEmployee(Integer Id) {
			// TODO Auto-generated method stub
	    repo.deleteById(Id);
		}

		@Override
		public EmployeeEntity getoneemployee(Integer Id) {
			// TODO Auto-generated method stub
			Optional<EmployeeEntity> opt=repo.findById(Id);
			if(opt.isPresent())  
				return opt.get();
				else return null;
		}

		@Override
		public List<EmployeeEntity> getAllEmployee() {
			// TODO Auto-generated method stub
			return repo.findAll();
		}
}
