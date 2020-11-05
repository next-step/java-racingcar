package study.step3;

import java.util.*;

public class CarRacing {

    private final List<Integer> cars;
    private final RacingInput racingInput;
    private final ResultView printer;
    private int round = 0;

    public static void main(String... args) {

        InputView inputView = new InputView();
        RacingInput racingInput = inputView.getRacingInput();

        CarRacing cr = new CarRacing(racingInput, new ResultView());
        cr.run();
    }

    public CarRacing(RacingInput racingInput, ResultView printer) {
        this.racingInput = racingInput;
        this.cars = initRacing(racingInput.getCountOfCar());
        this.printer = printer;
    }

    private List<Integer> initRacing(int cars) {
        return new ArrayList<>(Collections.nCopies(cars, 0));
    }

    public void run() {

        int round = 0;
        while (round++ < racingInput.getCountOfRound()) {
            processRound();
            printResult();
        }
    }

    private void processRound() {
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

    private void printResult() {
        printer.printResult(round, cars);
    }

}
