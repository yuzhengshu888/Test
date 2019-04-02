package com.yzs;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "user", catalog = "")
public class UserEntity {
    private int username;
    private int password;

    @Id
    @Column(name = "username")
    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return username == that.username &&
                password == that.password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
