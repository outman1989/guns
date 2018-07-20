package com.stylefeng.guns.core.common.constant;

/**
 * 系统常量
 *
 * @author fengshuonan
 * @date 2017年2月12日 下午9:42:53
 */
public interface Const {

    /**
     * 系统默认的管理员密码
     */
    String DEFAULT_PWD = "111111";

    /**
     * 管理员角色的名字
     */
    String ADMIN_NAME = "administrator";

    /**
     * 管理员id
     */
    Integer ADMIN_ID = 1;

    /**
     * 超级管理员角色id
     */
    Integer ADMIN_ROLE_ID = 1;

    /**
     * 记住用户的cookie 秘钥
     */
    String REMEMBER_ME_KEY = "b3V0TWFuX011WWEhKSgqJg==";//    System.out.println(Base64.encodeToString("outMan_MuYa!)(*&".getBytes())); System.out.println(Base64.decode("b3V0TWFuX011WWEhKSgqJg==").length);

}
