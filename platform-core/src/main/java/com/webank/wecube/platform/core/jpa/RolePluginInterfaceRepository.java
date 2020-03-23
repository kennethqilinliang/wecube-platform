package com.webank.wecube.platform.core.jpa;

import com.webank.wecube.platform.core.domain.RolePluginInterface;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RolePluginInterfaceRepository extends CrudRepository<RolePluginInterface, String> {

    Optional<List<RolePluginInterface>> findAllByRoleName(String roleName);

    Boolean existsRoleMenuByRoleNameAndPluginInterfaceId(String roleName, String pluginInterfaceId);

}
