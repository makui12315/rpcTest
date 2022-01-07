package com.xmg.service;

import com.xmg.remoteApi.PermissionApi;
import com.xmg.support.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xmg.server.support.annotation.RpcProvider;

import java.util.HashMap;
import java.util.Map;

@Service
@RpcProvider
@RequiredArgsConstructor
public class PermissionService {
    private static final Map<String, Permission> permissionMap = new HashMap<>();
    private final PermissionApi permissionApi;

    static {
        permissionMap.put("laoWang", new Permission("管理员"));
        permissionMap.put("laoZhang", new Permission("客服"));
        permissionMap.put("laoLi", new Permission("游客"));
    }

    public Permission permission(String username) {
        final Permission permission = permissionApi.permission(username);
        return permissionMap.get(username);
    }

}
