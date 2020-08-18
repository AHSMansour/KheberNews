package com.abomansour.khabernews.modules;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class news {

    @SerializedName("status")
    @Expose
    private  String status;

    @SerializedName("totalResults")
    @Expose
    private String totalResults;

    @SerializedName("articles")
    @Expose
    private List<Artcail> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<Artcail> getArticles() {
        return articles;
    }

    public void setArticles(List<Artcail> articles) {
        this.articles = articles;
    }
}
