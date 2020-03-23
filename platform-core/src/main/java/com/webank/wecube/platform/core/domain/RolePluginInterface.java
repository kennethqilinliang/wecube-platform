package com.webank.wecube.platform.core.domain;

import com.webank.wecube.platform.core.utils.Constants;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role_plugin_interface")
public class RolePluginInterface {

    @Id
    private String id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "plugin_interface_id")
    private String pluginInterfaceId;

    public RolePluginInterface(String roleName, String pluginInterfaceId) {
        this.roleName = roleName;
        this.pluginInterfaceId = pluginInterfaceId;
    }

    public RolePluginInterface() {
    }

    @PrePersist
    public void initGuid() {
        if (this.id == null || "".equals(this.id)) {
            this.id = Objects.requireNonNull(this.roleName, "The [roleName] cannot be NULL while persisting [role_plugin_interface]")
                    + Constants.KEY_COLUMN_DELIMITER
                    + Objects.requireNonNull(this.pluginInterfaceId, "The [pluginInterfaceId] cannot be NULL while persisting [role_plugin_interface]");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPluginInterfaceId() {
        return pluginInterfaceId;
    }

    public void setPluginInterfaceId(String pluginInterfaceId) {
        this.pluginInterfaceId = pluginInterfaceId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
