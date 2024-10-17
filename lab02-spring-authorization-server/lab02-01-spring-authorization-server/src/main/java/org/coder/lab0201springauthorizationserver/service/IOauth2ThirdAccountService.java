package org.coder.lab0201springauthorizationserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.coder.lab0201springauthorizationserver.entity.Oauth2ThirdAccount;

/**
 * <p>
 * 三方登录账户信息表 服务类
 * </p>
 *
 * @author vains
 * @since 2023-07-04
 */
public interface IOauth2ThirdAccountService extends IService<Oauth2ThirdAccount> {

    public void checkAndSaveUser(Oauth2ThirdAccount thirdAccount);
}
