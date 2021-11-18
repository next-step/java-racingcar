package step3;

public class Attempt {
    int number;

    public Attempt(int number) {
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
}
