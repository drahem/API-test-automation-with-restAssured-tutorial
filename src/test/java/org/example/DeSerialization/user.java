package org.example.DeSerialization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"support"})
public class user {
    userData data;

    public userData getData() {
        return data;
    }

    public void setData(userData data) {
        this.data = data;
    }
}
