package StringCalculator;

public class Numeric {
    private int data;

    public static Numeric of(String data) {
        if (data == null || data.isEmpty()
                || !Character.isDigit(data.charAt(0))) {
            throw new IllegalArgumentException();
        }
        return new Numeric(Integer.parseInt(data));
    }

    public int getData() {
        return this.data;
    }

    private Numeric(int data) {
        this.data = data;
    }

    private Numeric() {
    }
}
