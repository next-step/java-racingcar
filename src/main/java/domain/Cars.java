package domain;

import exception.CarNameTooLongException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int MAX_NAME_LENGTH = 5;

    public static List<Car> create(String names) {
        List<String> nameList = splitCarNames(names);

        for (String name : nameList) {
            checkLessThanSixLetters(name);
        }
        return nameList.stream()
                .map(Car::create)
                .collect(Collectors.toList());
    }

    public static List<String> splitCarNames(String names) {
        return Arrays.asList(names.split(","));
    }

    public static void checkLessThanSixLetters(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new CarNameTooLongException("자동차 이름은 5자까지만 가능합니다.");
        }
    }

}
