/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yhary
 */
public class User {

    private final String username;

    private final boolean canCreate;
    private final boolean canRead;
    private final boolean canUpdate;
    private final boolean canDelete;

    public User(String username, boolean canCreate, boolean canRead, boolean canUpdate, boolean canDelete) {
        this.username = username;
        this.canCreate = canCreate;
        this.canRead = canRead;
        this.canUpdate = canUpdate;
        this.canDelete = canDelete;
    }

    public String getUsername() {
        return username;
    }

    public boolean canCreate() {
        return canCreate;
    }

    public boolean canRead() {
        return canRead;
    }

    public boolean canUpdate() {
        return canUpdate;
    }

    public boolean canDelete() {
        return canDelete;
    }
}
