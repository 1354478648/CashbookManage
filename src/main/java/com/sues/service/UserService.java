package com.sues.service;

import jakarta.servlet.http.HttpSession;

public interface UserService {
    boolean auth(String username, String password, HttpSession session);

    void updateName(String name,String id);

    void updatePassword(String password,String id);

    String getOriginPassword(String id);
}
