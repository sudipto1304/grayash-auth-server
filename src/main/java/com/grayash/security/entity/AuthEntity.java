package com.grayash.security.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "DATA_CUSTOMER_INFORMATION")
@Data
public class AuthEntity implements Serializable {

    @Id
    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="ZIP_CODE")
    private Long zipCode;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="UPDATE_TIME")
    private String lastUpdateTime;

    @Column(name="COUNTRY_CODE")
    private String countryCode;

    @Column(name="SOCIAL_MEDIA_TYPE")
    private String socialMedia;

    @Column(name="ACCOUNT_STATUS")
    private String accountStatus;

    @Column(name="PHONE_VERIFIED")
    private String phoneVerify;


    @Column(name="USER_ID")
    private String userId;

    @Column(name="EMAIL_ID")
    private String emailId;

    @Column(name="PHONE_NUMBER")
    private String phoneNumber;


}

