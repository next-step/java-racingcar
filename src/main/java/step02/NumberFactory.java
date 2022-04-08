package step02;

public class NumberFactory {

    public static Number from(int number) {
        if (number > 0) {
            return new PositiveNumber(number);
        }

        if (number == 0) {
            return new Zero();
        }

        throw new IllegalArgumentException("음수 값을 포함하고 있습니다.");
    }

}
