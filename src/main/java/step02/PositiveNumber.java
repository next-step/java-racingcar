package step02;

public class PositiveNumber extends Number {

    public PositiveNumber(int value) {
        super(value);
        validate(value);
    }

    public void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("잘못된 객체 생성입니다.");
        }
    }

}
