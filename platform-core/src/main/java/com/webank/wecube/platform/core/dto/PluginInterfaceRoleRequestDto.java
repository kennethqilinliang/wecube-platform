package com.webank.wecube.platform.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PluginInterfaceRoleRequestDto {
    @JsonProperty(value = "roleNameList")
    List<String> roleNameList;

    public PluginInterfaceRoleRequestDto() {
    }

    public PluginInterfaceRoleRequestDto(List<String> roleIdList) {
        this.roleNameList = roleIdList;
    }

    public List<String> getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(List<String> roleNameList) {
        this.roleNameList = roleNameList;
    }
}
