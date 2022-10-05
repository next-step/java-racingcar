package com.nextlevel.kky.racing.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarNameValidator {

    final static Pattern pattern = Pattern.compile("^[A-Za-z]{1,5}$", Pattern.MULTILINE);

    public static boolean checkValidation(String name) {
        Matcher matcher = pattern.matcher(name);

        return matcher.find();
    }
}
