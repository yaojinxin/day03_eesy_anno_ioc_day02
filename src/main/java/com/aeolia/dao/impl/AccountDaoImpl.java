package com.aeolia.dao.impl;

import com.aeolia.dao.AccountDao;
import com.aeolia.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName： AccountDaoImpl
 * @Description： TODO 账户的持久层实现类
 * @Author： 姚金鑫
 * @Date： 2021/4/5 0:14
 * @Version： 1.0
 **/
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner queryRunner;


    @Override
    public List<Account> findAllAccount() {
        try {
            return queryRunner.query("select * from account",new BeanListHandler<>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer id) {
        try {
            return queryRunner.query("select * from account where id = "+ id,new BeanHandler<>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            queryRunner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            queryRunner.update("update account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccountById(Integer id) {
        try {
            queryRunner.update("delete from account where id = ?",id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
