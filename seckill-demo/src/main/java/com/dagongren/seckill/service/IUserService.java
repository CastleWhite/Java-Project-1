package com.dagongren.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dagongren.seckill.pojo.User;
import com.dagongren.seckill.vo.LoginVo;
import com.dagongren.seckill.vo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sxy
 * @since 2021-04-04
 */
public interface IUserService extends IService<User> {

    RespBean doLogin(LoginVo loginVo);
}
