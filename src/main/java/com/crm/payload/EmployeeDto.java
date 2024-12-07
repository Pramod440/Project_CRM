package com.crm.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeDto {

     private Long id;

     @NotBlank  //@NotBlank: Ensures the field is not null and contains at least one non-whitespace character.
     @Size(min = 2, message="Atleast 2 characters required")
    private String name;


     @Email
    private String emailId;

    @Size(min = 10, max = 10, message="Enter valid mobile number")
    private String mobile;

  //  private Date date;

    public String getMobile() {
        return mobile;
    }

    public String getEmailId() {

        return emailId;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

//    public void setDate(Date date) {
//        this.date=date;
//    }

    public Long getId() {
        return id;
    }

}