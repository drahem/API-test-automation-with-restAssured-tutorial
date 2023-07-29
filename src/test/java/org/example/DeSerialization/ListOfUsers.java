package org.example.DeSerialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties({"support"})
public class ListOfUsers {

    int page, perPage,total, totalPages;
    List<userData> data;

    @JsonProperty("data")
    public List<userData> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<userData> data) {
        this.data = data;
    }

    @JsonProperty("page")
    public int getPage() {
        return page;
    }
    @JsonProperty("page")
    public void setPage(int page) {
        this.page = page;
    }
    @JsonProperty("per_page")
    public int getPerPage() {
        return perPage;
    }
    @JsonProperty("per_page")
    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }
    @JsonProperty("total")
    public int getTotal() {
        return total;
    }
    @JsonProperty("total")
    public void setTotal(int total) {
        this.total = total;
    }
    @JsonProperty("total_pages")
    public int getTotalPages() {
        return totalPages;
    }
    @JsonProperty("total_pages")
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
