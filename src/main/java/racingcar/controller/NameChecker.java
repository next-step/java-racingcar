package racingcar.controller;

public class NameChecker {
    public static void checkNames(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("5글자 이상의 차 이름이 포함되어있습니다.");
            }
        }
    }
}
