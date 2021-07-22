package step3;

public class Referee {

    private final int limitTime;
    private int remainTime;

    public Referee(int limitTime) {
        this.limitTime = limitTime;
    }

    public boolean isOverTheTime() {
        return remainTime == limitTime;
    }

    public void hasPassedTime() {
        this.remainTime++;
    }

    public int getLimitTime() {
        return limitTime;
    }
}
