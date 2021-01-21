package racingcar.controller;

public class NameSpliter {
    public static String[] splitNames(String inputNames){
        String[] names = inputNames.split(",");
        NameChecker.checkNames(names);
        return names;
    }
}
