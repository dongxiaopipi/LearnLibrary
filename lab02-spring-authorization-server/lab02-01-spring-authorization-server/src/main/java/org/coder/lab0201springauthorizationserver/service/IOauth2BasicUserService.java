package org.coder.lab0201springauthorizationserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.coder.lab0201springauthorizationserver.entity.Oauth2BasicUser;
import org.coder.lab0201springauthorizationserver.entity.Oauth2ThirdAccount;

/**
 * <p>
 * 基础用户信息表 服务类
 * </p>
 *
 * @author vains
 * @since 2023-07-04
 */
public interface IOauth2BasicUserService extends IService<Oauth2BasicUser> {

    public Integer saveByThirdAccount(Oauth2ThirdAccount thirdAccount);
}
