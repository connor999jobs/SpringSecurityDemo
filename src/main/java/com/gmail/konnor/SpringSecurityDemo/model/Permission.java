package com.gmail.konnor.SpringSecurityDemo.model;

public enum Permission {
    DEVELOPERS_READ("developers_read"),
    DEVELOPERS_WRITE("developers_write"),

    ;
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
