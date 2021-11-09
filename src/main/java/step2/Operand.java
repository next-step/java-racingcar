package step2;

public class Operand {

    private final int number;

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

    //비즈니스 메서드
    public Operand plus(Operand other) {
        return new Operand(this.number + other.number);
    }

    public Operand minus(Operand other) {
        return new Operand(this.number - other.number);
    }

    public Operand multiply(Operand other) {
        return new Operand(this.number * other.number);
    }

    public Operand divide(Operand other) {
        return new Operand(this.number / other.number);
    }

    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(Operand.class)) {
            return false;
        }
        Operand other = (Operand) o;
        return this.number == other.number;
    }
}
