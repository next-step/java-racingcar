package step02;

public class Zero extends Number {

    public Zero(int value) {
        super(value);
        validate(value);
    }

    @Override
    public void validate(int value) {
        if (value != 0) {
            throw new IllegalArgumentException("잘못된 객체 생성입니다.");
        }
    }

}
