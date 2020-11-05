package study.step3;

import java.util.*;

public class CarRacing {

    private final List<Integer> cars;
    private ResultView printer;
    private int round = 0;

    public CarRacing(int countOfCars, ResultView printer) {
        this.cars = initRacing(countOfCars);
        this.printer = printer;
    }

    private List<Integer> initRacing(int cars) {
        return new ArrayList<>(Collections.nCopies(cars, 0));
    }

    public static void main(String... args) {

        InputView inputView = new InputView();
        RacingInput racingInput = inputView.getRacingInput();

        CarRacing cr = new CarRacing(racingInput.getCountOfCar(), new ResultView());
        List<Integer> cars = cr.initRacing(racingInput.getCountOfCar());

        int round = 0;

        while (round++ < racingInput.getCountOfRound()) {
            cr.processRound();
            cr.printResult();
        }
    }

    public void printResult() {
        printer.printResult(round, cars);
    }

    public void processRound() {
        for (int i = 0; i < cars.size(); i++) {
            if (getRandomNumber() >= 4) {
                cars.set(i, cars.get(i) + 1);
            }
        }
        round++;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
