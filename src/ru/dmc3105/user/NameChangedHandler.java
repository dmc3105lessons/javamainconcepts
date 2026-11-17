package ru.dmc3105.user;

@FunctionalInterface
public interface NameChangedHandler {
    void onNameChanged(String oldName, String newName);
}
