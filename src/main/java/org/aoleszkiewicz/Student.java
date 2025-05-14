package org.aoleszkiewicz;

import org.aoleszkiewicz.annotation.AcademicIndexNumber;
import org.aoleszkiewicz.annotation.Email;
import org.aoleszkiewicz.annotation.NotNull;
import org.aoleszkiewicz.annotation.Size;

public class Student {
    @NotNull
    @Size(min = 2, max = 30)
    protected String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    protected String lastName;

    @NotNull
    @Email
    protected String email;

    @NotNull
    @AcademicIndexNumber(length = 6)
    protected String indexNumber;

    public Student(String firstName, String lastName, String email, String indexNumber) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setIndexNumber(indexNumber);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }
}
