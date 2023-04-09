package racing;

public class RacingGame {
    private final int numOfCar;
    private final int numOfCycle;

    public RacingGame(int numOfCar, int numOfCycle) {
        this.numOfCar = numOfCar;
        this.numOfCycle = numOfCycle;
    }

    public void info() {
        System.out.println("자동차 수: " + this.numOfCar + ", 사이클 수: " + this.numOfCycle);
    }
}
