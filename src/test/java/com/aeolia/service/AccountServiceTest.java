package com.aeolia.service;

import com.aeolia.domain.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * 使用Junit单元测试：测试我们的配置
 */
public class AccountServiceTest {
    private ApplicationContext context;
    private AccountService accountService;


    @Before
    public void setUp() throws Exception {
        //1.获取容器
        context=new ClassPathXmlApplicationContext("bean.xml");
        //2.获取业务层对象
        accountService = context.getBean("accountService", AccountService.class);
    }

    @Test
    public void findAllAccount() {
        //3.执行方法
        List<Account> accounts = accountService.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void findAccountById() {
        Account account = accountService.findAccountById(2);
        System.out.println(account);
    }

    @Test
    public void saveAccount() {
        Account account=new Account();
        account.setName("张三");
        account.setMoney(1500F);
        accountService.saveAccount(account);
        System.out.println("=========================");
        findAllAccount();
    }

    @Test
    public void updateAccount() {
        Account accountBefore = accountService.findAccountById(1);
        System.out.println("Before:"+accountBefore);

        int anInt = new Random().nextInt(10001);
        accountBefore.setMoney((float) anInt);


        accountService.updateAccount(accountBefore);

        Account accountAfter = accountService.findAccountById(1);
        System.out.println("After:"+accountAfter);
    }

    /**
     * 测试根据Id删除Account
     */
    @Test
    public void deleteAccountById() {
        accountService.deleteAccountById(6);
        findAllAccount();
    }
}