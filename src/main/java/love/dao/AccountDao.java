package love.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import love.entity.Account;
import love.entity.Image;

public interface AccountDao extends JpaRepository<Account, String>{

}
