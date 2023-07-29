package org.example.DeSerialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class userData {

    int id;
    String email, firstName, lastName, avatar;

    @JsonProperty("id")
    public int getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @JsonProperty("avatar")
    public String getAvatar() {
        return avatar;
    }
    @JsonProperty("avatar")
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
