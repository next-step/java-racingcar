package calculator2;

public class StringNumber {
    private int number;

    private StringNumber(int number) {
        this.number = number;
    }

    public static StringNumber create(String text) {
        int num = Integer.parseInt(text);
        if(num < 0) {
            throw new IllegalArgumentException();
        }
        return new StringNumber(num);
    }

    public int getNumber() {
        return number;
    }
}
