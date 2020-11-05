package study.step3;

import java.util.*;

public class CarRacing {

    public List<Integer> initRacing(int cars) {
        return new ArrayList<>(Collections.nCopies(cars, 0));
    }

    public static void main(String... args) {

        InputView inputView = new InputView();
        RacingInput racingInput = inputView.getRacingInput();

        CarRacing cr = new CarRacing();
        List<Integer> cars = cr.initRacing(racingInput.getCountOfCar());

        ResultView resultView = new ResultView();

        int round = 0;

        while (round++ < racingInput.getCountOfRound()) {
            cr.processRound(cars);
            resultView.printResult(round, cars);
        }
    }

    public void processRound(List<Integer> cars) {
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
