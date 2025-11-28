package com.example.helloandroid.data;

public class User {
    public Name name;
    public Picture picture;

    public static class Name {
        public String first;
        public String last;
    }

    public static class Picture {
        public String thumbnail;
        public String medium;
        public String large;
    }

    public String getFullName() {
        return name.first + " " + name.last;
    }
}