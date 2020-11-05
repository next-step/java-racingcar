package study.step3;

import java.util.*;

public class CarRacing {

    private final int maxRound;
    private final List<Integer> cars;

    public CarRacing(RacingInput racingInput) {
        maxRound = racingInput.getCountOfRound();
        cars = initRacing(racingInput.getCountOfCar());
    }

    private List<Integer> initRacing(int cars) {
        return new ArrayList<>(Collections.nCopies(cars, 0));
    }

    public static void main(String... args) {

        InputView inputView = new InputView();
        RacingInput racingInput = inputView.getRacingInput();

        CarRacing cr = new CarRacing(racingInput);
        cr.run();
    }

    private void run() {

        int count = 0;
        ResultView resultView = new ResultView();
        while (count++ < maxRound) {
            processRound(cars);
            resultView.printResult(cars);
        }
    }

    private void processRound(List<Integer> cars) {
        for (int i = 0; i < cars.size(); i++) {
            if (getRandomNumber() >= 4) {
                cars.set(i, cars.get(i) + 1);
            }
        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
