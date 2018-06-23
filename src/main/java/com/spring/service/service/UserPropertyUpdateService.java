package com.spring.service.service;

import com.wang.bean.doo.UserDO;
import com.wang.service.Service;

/**
 * 用户资料更新
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserPropertyUpdateService extends Service {
    void updateUserProperty(UserDO userDO);
}