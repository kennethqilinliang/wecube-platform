package com.webank.wecube.platform.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PluginInterfaceRoleRequestDto {
    @JsonProperty(value = "roleIdList")
    List<String> roleIdList;

    public PluginInterfaceRoleRequestDto() {
    }

    public PluginInterfaceRoleRequestDto(List<String> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public List<String> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<String> roleIdList) {
        this.roleIdList = roleIdList;
    }
}
