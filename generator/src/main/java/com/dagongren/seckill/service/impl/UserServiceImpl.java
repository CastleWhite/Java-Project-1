package com.dagongren.seckill.service.impl;

import com.dagongren.seckill.pojo.User;
import com.dagongren.seckill.mapper.UserMapper;
import com.dagongren.seckill.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sxy
 * @since 2021-04-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
