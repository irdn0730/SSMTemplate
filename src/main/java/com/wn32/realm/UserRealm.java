package com.wn32.realm;

import com.wn32.model.User;
import com.wn32.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthenticatingRealm {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String)authenticationToken.getPrincipal();
        User user = userService.findUserByName(userName);

        ByteSource salt = ByteSource.Util.bytes(userName);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, "9f9d65c2bfec923887a90cc3d2d6ac43", salt,this.getName());

        return info;
    }
}
