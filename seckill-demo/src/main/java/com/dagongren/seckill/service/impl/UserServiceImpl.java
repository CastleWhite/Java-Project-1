package com.dagongren.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dagongren.seckill.mapper.UserMapper;
import com.dagongren.seckill.pojo.User;
import com.dagongren.seckill.service.IUserService;
import com.dagongren.seckill.utils.MD5Util;
import com.dagongren.seckill.utils.ValidatorUtil;
import com.dagongren.seckill.vo.LoginVo;
import com.dagongren.seckill.vo.RespBean;
import com.dagongren.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

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
    @Autowired
    private UserMapper userMapper;

    @Override
    public RespBean doLogin(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
            return  RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if (!ValidatorUtil.isMobile(mobile)){
            return  RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }
        // 根据手机号获取用户
        User user = userMapper.selectById(mobile);
        if (null==user){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        // 判断密码是否正确
        if (!MD5Util.formPassToDBPass(password,user.getSalt()).equals(user.getPassword())){
            return RespBean.error((RespBeanEnum.LOGIN_ERROR));
        }
        return RespBean.success();
    }
}
