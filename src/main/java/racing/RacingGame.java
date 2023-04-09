package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final ResultView rv = new ResultView();
    private final int numOfCars;
    private final int numOfCycles;
    private final List<RacingCar> gameCars;

    public RacingGame(int numOfCars, int numOfCycles) {
        this.numOfCars = numOfCars;
        this.numOfCycles = numOfCycles;
        this.gameCars = createCarList();
    }

    public RacingGame() {
        InputView iv = new InputView();
        this.numOfCars = iv.readNumberOfCars();
        this.numOfCycles = iv.readNumberOfCycles();
        this.gameCars = createCarList();
    }

    private List<RacingCar> createCarList() {
        List<RacingCar> carList = new ArrayList<>();
        for (int i = 0; i < this.numOfCars; i++) {
            carList.add(new RacingCar());
        }
        return carList;
    }

    public void start() {
        rv.printStartMessage();
        for (int i = 0; i < this.numOfCycles; i++) {
            progressCycle();
        }
    }

    private void progressCycle() {
        ongoingEachCar();
        rv.printCarListStatus(this.gameCars);
    }

    private void ongoingEachCar() {
        for (int i = 0; i < this.numOfCars; i++) {
            this.gameCars.get(i).ongoing();
        }
    }

    public List<Integer> result() {
        List<Integer> carStatusList = new ArrayList<>();
        for (int i = 0; i < this.numOfCars; i++) {
            int carStatus = this.gameCars.get(i).getNumberOfOngoing();
            carStatusList.add(carStatus);
        }
        return carStatusList;
    }


    public void info() {
        System.out.println("자동차 수: " + this.numOfCars + ", 사이클 수: " + this.numOfCycles);
    }
}
