package step2;

public class Positive {
    public int value;

    Positive(String text) {
        this(Integer.parseInt(text));
    }

    Positive(int value) {
        if (value < 0) {
            throw new RuntimeException();
        }
        this.value = value;
    }
}
