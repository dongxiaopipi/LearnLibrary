package org.coder.lab0201springauthorizationserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.coder.lab0201springauthorizationserver.entity.SysAuthority;

import java.util.List;

/**
 * <p>
 * 系统菜单表 服务类
 * </p>
 *
 * @author vains
 * @since 2023-07-04
 */
public interface ISysAuthorityService extends IService<SysAuthority> {

    /**
     * 根据用户id获取权限列表
     *
     * @param userId 用户id
     * @return 权限列表
     */
    List<SysAuthority> getByUserId(Integer userId);
}
