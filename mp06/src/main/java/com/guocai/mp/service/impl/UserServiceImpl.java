package com.guocai.mp.service.impl;

import com.guocai.mp.entity.User;
import com.guocai.mp.mapper.UserMapper;
import com.guocai.mp.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Sun GuoCai
 * @since 2018-07-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
