package com.store.backend.model;

public enum UserRole {
    USER("USER"),
    ADMIN("ADMIN")
    ;

    private final String text;

    UserRole(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
