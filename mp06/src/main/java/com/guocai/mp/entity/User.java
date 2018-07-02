package com.guocai.mp.entity;

import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Sun GuoCai
 * @since 2018-07-02
 */
@KeySequence(value = "seq_user",clazz = Integer.class)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer logicFlag;


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

    public Integer getLogicFlag() {
        return logicFlag;
    }

    public void setLogicFlag(Integer logicFlag) {
        this.logicFlag = logicFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        ", id=" + id +
        ", name=" + name +
        ", logicFlag=" + logicFlag +
        "}";
    }
}
