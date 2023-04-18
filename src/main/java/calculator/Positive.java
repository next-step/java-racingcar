package calculator;

public class Positive {
    private final int number;

    public Positive(String s) {
        this.number = Integer.parseInt(s);
    }
    public int getNumber() {
        // getter 안 쓰고 어떻게 하지 ?
        // -> input, output 래핑한 객체를 리턴하는 것 어떨까..
        return this.number;
    }
}
