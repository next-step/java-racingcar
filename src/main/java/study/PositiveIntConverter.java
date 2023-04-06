package study;

import java.util.ArrayList;
import java.util.List;

public class PositiveIntConverter {

    public static List<Integer> toPositiveInts(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (String n : values) {
            numbers.add(toPositiveInt(n));
        }
        return numbers;
    }

    private static int toPositiveInt(String value) {
        int number = getNumber(value);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private static int getNumber(String value) {
        int number;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new RuntimeException("숫자 이외의 값은 변환할 수 없습니다.");
        }
        return number;
    }
}
