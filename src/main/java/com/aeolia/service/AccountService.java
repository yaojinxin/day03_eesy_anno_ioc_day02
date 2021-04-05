package com.aeolia.service;

import com.aeolia.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface AccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存Account
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新Account
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 根据Id删除Account
     * @param id
     */
    void deleteAccountById(Integer id);
}
