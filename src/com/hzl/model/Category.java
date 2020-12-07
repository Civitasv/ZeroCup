package com.hzl.model;

import java.util.HashSet;
import java.util.Set;

public class Category {

    private String category;
    private Set<Poi> news = new HashSet<Poi>();
    private Set<User> users = new HashSet<User>();

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Poi> getNews() {
        return news;
    }

    public void setNews(Set<Poi> news) {
        this.news = news;
    }

    public Category(String category) {
        super();
        this.category = category;
    }

    public Category() {

    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Category [category=" + category + "]";
    }
}
