package love.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import love.dao.AccountDao;
import love.entity.Account;
import love.entity.Image;
import love.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDao dao;

	@Override
	public Account finfById(String username) {

		return dao.findById(username).get();
	}
	
	
}
