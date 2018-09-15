package com.example.moon.movie;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("poster_path")
    private String posterpath;
    @SerializedName("original_title")
    private String originaltitle;
    @SerializedName("adult")
    private String adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("vote_average")
    private Double voteaverage;
    @SerializedName("release_date")
    private String releasedate;

    public Movie(String posterpath, String originaltitle, String adult, String overview, Double voteaverage, String releasedate) {
        this.posterpath = posterpath;
        this.originaltitle = originaltitle;
        this.adult = adult;
        this.overview = overview;
        this.voteaverage = voteaverage;
        this.releasedate = releasedate;
    }
    public String getPosterpath (){
        return  "http://image.tmdb.org/t/p/w185"+posterpath;
    }

    public void setPosterpath(String posterpath) {
        this.posterpath = posterpath;
    }

    public String getOriginaltitle() {
        return originaltitle;
    }

    public void setOriginaltitle(String originaltitle) {
        this.originaltitle = originaltitle;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getVoteaverage() {
        return voteaverage;
    }

    public void setVoteaverage(Double voteaverage) {
        this.voteaverage = voteaverage;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }
}
