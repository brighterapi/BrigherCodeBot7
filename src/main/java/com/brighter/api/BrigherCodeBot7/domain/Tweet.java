package com.brighter.api.BrigherCodeBot7.domain;

public class Tweet {
        Long id;
        String lang;
        String text;
        User user;

        public Tweet(Long id, String lang, String text, User user) {
                this.id = id;
                this.lang = lang;
                this.text = text;
                this.user = user;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getLang() {
                return lang;
        }

        public void setLang(String lang) {
                this.lang = lang;
        }

        public String getText() {
                return text;
        }

        public void setText(String text) {
                this.text = text;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }
}
