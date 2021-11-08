package step2;

public class MyNumber {

    private final int num;

    public MyNumber(int num) {
        this.num = num;
    }

    public MyNumber(String s) {
        num = Integer.parseInt(s);
    }

    public MyNumber plus(MyNumber other) {
        return new MyNumber(this.num + other.num);
    }

    public MyNumber minus(MyNumber other) {
        return new MyNumber(this.num - other.num);
    }

    public MyNumber multiply(MyNumber other) {
        return new MyNumber(this.num * other.num);
    }

    public MyNumber divide(MyNumber other) {
        return new MyNumber(this.num / other.num);
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != MyNumber.class) {
            return false;
        }
        MyNumber other = (MyNumber) o;
        if (this.num == other.num) {
            return true;
        }
        return false;
    }
}
