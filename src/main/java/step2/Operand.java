package step2;

public class Operand {

    private int number;

    //생성자 목록
    public Operand(int number) {
        this.number = number;
    }

    public Operand(String number) {
        this(Integer.parseInt(number));
    }

    public Operand(Operand other) {
        this(other.number);
    }
}
