package com.funmilola.leaderboard;


public class LearningModel {

    String name, country ;
    int hours;
    String badgeUrl;

    public LearningModel(String name, String country, int hours, String badgeUrl) {
        this.name = name;
        this.country = country;
        this.hours = hours;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}



