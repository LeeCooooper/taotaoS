package com.taotao.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class ItemCat implements Serializable {
    @JsonProperty("u")
    private String url;
    @JsonProperty("n")
    private String name;
    @JsonProperty("i")
    private List<?> items;  @Override
    public String toString() {
        return "ItemCatResult{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<?> getItems() {
        return items;
    }

    public void setItems(List<?> items) {
        this.items = items;
    }
}
