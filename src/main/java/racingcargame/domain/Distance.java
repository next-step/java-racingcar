package racingcargame.domain;

public class Distance {
    private int value;

    public Distance(int value) {
        this.value = value;
    }

    public int increase() {
        return ++value;
    }

    public int getValue() {
        return value;
    }

    public boolean isSame(int winnerDistance) {
        if(this.value == winnerDistance) {
            return true;
        }
        return false;
    }
}