package calculatorrefactor;

public class Positive {
    private int num;

    public Positive(int num) {
        validatePositiveNumber(num);
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    // TODO: 추가 기능. MinusRuntimeException + msg 추가
    private void validatePositiveNumber(int num) {
        if (num < 0) throw new RuntimeException();
    }
}
