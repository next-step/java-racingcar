package com.kakao.racingcar.domain.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNameInfo {
    private static final String DELIMITER = ",";

    private UserNameInfo() {
    }

    public static List<String> parse(String userName) {
        return Arrays.stream(userName.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
