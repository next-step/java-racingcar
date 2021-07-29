package step5;

public class Referee {

    private static final int OVER_TIME = 0;
    private int limitTime;

    public Referee(int limitTime) {
        this.limitTime = limitTime;
    }

    public boolean isOverTime() {
        return limitTime == OVER_TIME;
    }

    public void passedTime() {
        this.limitTime--;
    }

    public int getLimitTime() {
        return limitTime;
    }
}
