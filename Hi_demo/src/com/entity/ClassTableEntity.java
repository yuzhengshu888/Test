package com.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "class_table", schema = "user", catalog = "")
public class ClassTableEntity {
    private long classId;
    private String className;

    @Id
    @Column(name = "class_id")
    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "class_name")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassTableEntity that = (ClassTableEntity) o;
        return classId == that.classId &&
                Objects.equals(className, that.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, className);
    }
}
