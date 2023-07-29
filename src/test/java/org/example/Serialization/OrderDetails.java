package org.example.Serialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDetails {

    int testId, petId, quantity;
    String shipDate, status;
    boolean complete;

    @JsonProperty("id")
    public int getId() {
        return testId;
    }

    @JsonProperty("id")
    public void setId(int testId) {
        this.testId = testId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
