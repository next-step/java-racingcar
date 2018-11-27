package racingGame.domain;

import racingGame.view.InputView;
import racingGame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static InputView inputView;
    private static OutputView outputView;
    private final int FORWARD_LIMIT = 4;
    private int rAttemptCnt = 0;
    private ArrayList<Car> cars = new ArrayList<>();

    public RacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() throws RuntimeException {
        gameSet(inputView.getInputCarsName(), this.inputView.getInputRunDistance());
        carsRun();
        outputView.viewWinnersName(getWinners());
    }

    private void gameSet(String[] carsName, int attemptCnt) {
        System.out.println("자동차 수는 몇 대 인가요?");
        outputView.viewCarsSize(carsName.length);

        System.out.println("시도할 횟수는 몇 회 인가요?");
        rAttemptCnt = attemptCnt;

        for (String carName : carsName) {
            this.cars.add(new Car.Builder().carName(carName).runMinPoint(0).runMaxPoint(9).build());
        }
    }

    private void carsRun() {
        for (int i = 0; i < rAttemptCnt; i++) {
            carRunOneTurn();
            outputView.viewEmptySpace();
        }
    }

    private void carRunOneTurn() {
        for (Car car : cars) {
            car.run(FORWARD_LIMIT);
            outputView.viewPrintCarName(car);
        }
    }

    public String[] getWinners() throws RuntimeException {
        if (cars.size() <= 0) {
            throw new RuntimeException();
        }

        return getWinnerCarsName(Car.getWinCars(cars, Car.getWinDistance(cars)));
    }

    private String[] getWinnerCarsName(List<Car> winnerCars) {
        String[] carsName = new String[winnerCars.size()];
        for (int i = 0; i < winnerCars.size(); i++) {
            carsName[i] = winnerCars.get(i).getCarName();
        }
        return carsName;
    }

    public ArrayList<Car> getCarList() {
        return this.cars;
    }
}
