package racingcar;

import racingcar.service.Move;
import racingcar.service.MoveRandom;
import racingcar.service.RacingCar;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;

    public static void main(String[] args) {
        ResultView.printNameOfCars();
        String nameOfCars = InputView.inputNameOfCars();

        ResultView.printNumberOfMovements();
        int movements = InputView.inputNumberOfMovements();

        Move move = new MoveRandom();
        RacingCar racingCar = new RacingCar(nameOfCars, move);
        int cars = racingCar.getCars().size();

        ResultView.printRacingResult();
        for (int i = 0; i < movements; i++) {
            racingCar.start(getRandomList(cars));
            ResultView.printStatusOfCars(racingCar.getCars());
        }

        ResultView.printWinners(racingCar.getWinner());
    }

    public static List<Integer> getRandomList(int numberOfCars){
        return IntStream.range(0, numberOfCars).map(index -> RANDOM.nextInt(BOUND)).boxed().collect(Collectors.toList());
    }
}
