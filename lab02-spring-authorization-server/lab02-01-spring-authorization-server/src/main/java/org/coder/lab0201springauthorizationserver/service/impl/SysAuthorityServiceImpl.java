package org.coder.lab0201springauthorizationserver.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.coder.lab0201springauthorizationserver.entity.SysAuthority;
import org.coder.lab0201springauthorizationserver.entity.SysRoleAuthority;
import org.coder.lab0201springauthorizationserver.entity.SysUserRole;
import org.coder.lab0201springauthorizationserver.mapper.SysAuthorityMapper;
import org.coder.lab0201springauthorizationserver.mapper.SysRoleAuthorityMapper;
import org.coder.lab0201springauthorizationserver.mapper.SysUserRoleMapper;
import org.coder.lab0201springauthorizationserver.service.ISysAuthorityService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统菜单表 服务实现类
 * </p>
 *
 * @author vains
 * @since 2023-07-04
 */
@Service
@RequiredArgsConstructor
public class SysAuthorityServiceImpl extends ServiceImpl<SysAuthorityMapper, SysAuthority> implements ISysAuthorityService {

    private final SysUserRoleMapper sysUserRoleMapper;

    private final SysRoleAuthorityMapper sysRoleAuthorityMapper;
    @Override
    public List<SysAuthority> getByUserId(Integer userId) {
        // 通过用户角色关联表查询对应的角色
        List<SysUserRole> userRoles = sysUserRoleMapper.selectList(Wrappers.lambdaQuery(SysUserRole.class).eq(SysUserRole::getUserId, userId));
        List<Integer> rolesId = Optional.ofNullable(userRoles).orElse(Collections.emptyList()).stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        if (ObjectUtils.isEmpty(rolesId)) {
            return Collections.emptyList();
        }
        // 通过角色菜单关联表查出对应的菜单
        List<SysRoleAuthority> roleMenus = sysRoleAuthorityMapper.selectList(Wrappers.lambdaQuery(SysRoleAuthority.class).in(SysRoleAuthority::getRoleId, rolesId));
        List<Integer> menusId = Optional.ofNullable(roleMenus).orElse(Collections.emptyList()).stream().map(SysRoleAuthority::getAuthorityId).collect(Collectors.toList());
        if (ObjectUtils.isEmpty(menusId)) {
            return Collections.emptyList();
        }

        // 根据菜单ID查出菜单
        return baseMapper.selectBatchIds(menusId);
    }
}
