package com.example.issuemanagmentproject.util;

public class ApiPaths
{

    private static final String BASE_PATH = "/api";

    public static final class IssuePath {
        public static final String CTRL = BASE_PATH + "/issue";
    }

    public static final class ProjectPath {
        public static final String CTRL = BASE_PATH + "/project";
    }
    public static final class UserPath {
        public static final String CTRL = BASE_PATH + "/users";
    }
}
