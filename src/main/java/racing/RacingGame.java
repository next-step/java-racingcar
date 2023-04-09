package racing;

public class RacingGame {
    private final InputView iv;
    private final int numOfCar;
    private final int numOfCycle;

    public RacingGame(int numOfCar, int numOfCycle) {
        iv = null;
        this.numOfCar = numOfCar;
        this.numOfCycle = numOfCycle;
    }

    public RacingGame() {
        iv = new InputView();
        this.numOfCar = iv.readNumberOfCars();
        this.numOfCycle = iv.readNumberOfCycles();
    }


    public void info() {
        System.out.println("자동차 수: " + this.numOfCar + ", 사이클 수: " + this.numOfCycle);
    }
}
