package ru.dmc3105.domain.user;

@FunctionalInterface
public interface NameChangedHandler {
    void onNameChanged(String oldName, String newName);
}
