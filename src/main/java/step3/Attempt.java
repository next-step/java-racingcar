package step3;

public class Attempt {
    private static final int END = 0;
    private int number;

    public Attempt(int number) {
        if(number < END) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    void make() {
        number--;
    }

    boolean isEnd() {
        if(number == END) {
            return true;
        }
        return false;
    }

    boolean isEqualNumber(int attemptCount) {
        if(number == attemptCount) {
            return true;
        }
        return false;
    }

}
