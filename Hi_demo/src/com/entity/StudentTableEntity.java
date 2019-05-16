package com.entity;

import javax.persistence.Entity;
import java.sql.Date;
import java.util.Objects;

@Entity
@javax.persistence.Table(name = "student_table", schema = "user", catalog = "")
public class StudentTableEntity {
    private long studentId;

    @javax.persistence.Id
    @javax.persistence.Column(name = "student_id")
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    private String studnetName;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "studnet_name")
    public String getStudnetName() {
        return studnetName;
    }

    public void setStudnetName(String studnetName) {
        this.studnetName = studnetName;
    }

    private String studentSex;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "student_sex")
    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    private Date studentBirth;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "student_birth")
    public Date getStudentBirth() {
        return studentBirth;
    }

    public void setStudentBirth(Date studentBirth) {
        this.studentBirth = studentBirth;
    }

    private long classId;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "class_id")
    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentTableEntity that = (StudentTableEntity) o;
        return studentId == that.studentId &&
                classId == that.classId &&
                Objects.equals(studnetName, that.studnetName) &&
                Objects.equals(studentSex, that.studentSex) &&
                Objects.equals(studentBirth, that.studentBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studnetName, studentSex, studentBirth, classId);
    }
}
