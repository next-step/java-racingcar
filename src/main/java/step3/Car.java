package step3;

public class Car {
    private static final int goCar = 4;

    private int goDistance;

    // 차가 앞으로 갈 수 있는지 없는지 여부
    public void carCanGoJudge() {
        int randomNumber = RandomNumber.randomNumberGenerator();

        if (randomNumber >= goCar) {
            goDistance++;
        }
    }

    public int getGoDistance() {
        return goDistance;
    }
}
