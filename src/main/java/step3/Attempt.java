package step3;

public class Attempt {
    private int number;

    public Attempt(int number) {
        if(number < 0) throw new IllegalArgumentException();
        this.number = number;
    }

    void make() {
        number--;
    }

    boolean isEnd() {
        if(number == 0) {
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
