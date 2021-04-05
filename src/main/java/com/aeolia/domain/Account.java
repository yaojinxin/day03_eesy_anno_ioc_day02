package com.aeolia.domain;

import java.io.Serializable;

/**
 * @ClassName： Account
 * @Description： TODO 账户的实体类接口
 * @Author： 姚金鑫
 * @Date： 2021/4/5 0:06
 * @Version： 1.0
 **/
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Float money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
}
