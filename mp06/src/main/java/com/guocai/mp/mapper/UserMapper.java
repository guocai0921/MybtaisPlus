package com.guocai.mp.mapper;

import com.guocai.mp.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Sun GuoCai
 * @since 2018-07-02
 */
public interface UserMapper extends BaseMapper<User> {
	public User insertByUserParams(Map<String,Object> map);
}
