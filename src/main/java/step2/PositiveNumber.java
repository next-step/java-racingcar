package step2;

public class PositiveNumber {

    public static Integer get(String number) {
        int num = Integer.parseInt(number);

        if (num < 0) {
            throw new IllegalArgumentException("음수는 더할 수 없습니다.");
        }

        return num;
    }
}
