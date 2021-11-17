package com.sprint.assessingdatarest;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String memberName;
    private String memberAddress;
    private String memberEmail;
    private String memberPhone;
    private LocalDate membershipStart;
    private String membershipType;
    private String currentTournament;
    private String previousTournament;

    public Members(long id, String memberName, String memberAddress, String memberEmail, String memberPhone, LocalDate membershipStart, String membershipType, String currentTournament, String previousTournament) {
        super();
        this.id = id;
        this.memberName = memberName;
        this.memberAddress = memberAddress;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
        this.membershipStart = membershipStart;
        this.membershipType = membershipType;
        this.currentTournament = currentTournament;
        this.previousTournament = previousTournament;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public LocalDate getMembershipStart() {
        return membershipStart;
    }

    public void setMembershipStart(LocalDate membershipStart) {
        this.membershipStart = membershipStart;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getCurrentTournament() {
        return currentTournament;
    }

    public void setCurrentTournament(String currentTournament) {
        this.currentTournament = currentTournament;
    }

    public String getPreviousTournament() {
        return previousTournament;
    }

    public void setPreviousTournament(String previousTournament) {
        this.previousTournament = previousTournament;
    }
}
