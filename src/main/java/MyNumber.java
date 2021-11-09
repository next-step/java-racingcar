import java.util.Objects;

public class MyNumber {
    int number;

    public MyNumber(int number) {
        this.number = number;
    }

    public MyNumber(String text) {
        this(Integer.parseInt(text));
    }

    public MyNumber plus(MyNumber second) {
        this.number = this.number + second.number;
        return this;
    }

    public MyNumber minus(MyNumber second) {
        this.number = this.number - second.number;
        return this;
    }

    public MyNumber multiply(MyNumber second) {
        this.number = this.number * second.number;
        return this;
    }

    public MyNumber divide(MyNumber second) {
        this.number = this.number / second.number;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyNumber myNumber = (MyNumber) o;
        return number == myNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
