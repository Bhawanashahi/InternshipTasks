package com.example.blogApi.endpoint;

import com.example.blogApi.repo.UserRepo;
import com.example.blogApi.service.AuthService;
import com.example.blogApi.service.UserService;
import com.example.blogApi.utils.Datasource;

public class BlogService {
    private static BlogService instance;

    private final UserService userService;

    private final AuthService authService;

    private BlogService() {
        Datasource datasource = new Datasource();
//        TicketRepo ticketRepo = new TicketRepo(datasource);
//        this.ticketService = new TicketService(ticketRepo);

        UserRepo userRepo = new UserRepo(datasource);
        this.userService = new UserService(userRepo);
        authService = new AuthService(userRepo);
    }

    public static BlogService getInstance() {
        if (instance == null) {
            instance = new BlogService();
        }
        return instance;
    }

//    public TicketService getTicketService() {
//        return ticketService;
//    }

    public UserService getUserService() {
        return userService;
    }

    public AuthService getAuthService() {
        return authService;
    }
}
