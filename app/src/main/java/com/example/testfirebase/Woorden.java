package com.example.testfirebase;

public class Woorden {
    private String audiopath;
    private Integer category;
    private String imagepath;
    private String woordamz;
    private Integer woordid;
    private String woordned;

    public Woorden(String audiopath, String imagepath, String woordamz, String woordned) {
        this.audiopath = audiopath;
        this.imagepath = imagepath;
        this.woordamz = woordamz;
        this.woordned = woordned;
    }

    public Woorden() {
        // empty constructor needed
    }

    public String getAudiopath() {
        return audiopath;
    }

    public void setAudiopath(String audiopath) {
        this.audiopath = audiopath;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getWoordamz() {
        return woordamz;
    }

    public void setWoordamz(String woordamz) {
        this.woordamz = woordamz;
    }

    public Integer getWoordid() {
        return woordid;
    }

    public void setWoordid(Integer woordid) {
        this.woordid = woordid;
    }

    public String getWoordned() {
        return woordned;
    }

    public void setWoordned(String woordned) {
        this.woordned = woordned;
    }

    public String toString() {
        return this.audiopath + " - " + this.imagepath + " - " + this.woordamz + " == " + this.woordned;
    }
}
