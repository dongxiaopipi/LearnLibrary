package org.coder.lab0201springauthorizationserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coder.lab0201springauthorizationserver.entity.SysRoleAuthority;
import org.coder.lab0201springauthorizationserver.mapper.SysRoleAuthorityMapper;
import org.coder.lab0201springauthorizationserver.service.ISysRoleAuthorityService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色菜单多对多关联表 服务实现类
 * </p>
 *
 * @author vains
 * @since 2023-07-04
 */
@Service
public class SysRoleAuthorityServiceImpl extends ServiceImpl<SysRoleAuthorityMapper, SysRoleAuthority> implements ISysRoleAuthorityService {

}
