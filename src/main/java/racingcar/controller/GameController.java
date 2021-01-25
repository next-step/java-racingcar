package racingcar.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.repository.CarRepository;
import racingcar.util.Constant;
import racingcar.util.RandomUtils;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameController {
    static final int START_POSITION = 0;
    static final int MOVE_THRESHOLD = 4;
    static final int RANDOM_START_INCLUSIVE = 0;
    static final int RANDOM_END_INCLUSIVE = 9;

    private final CarRepository carRepository;
    private RacingGame racingGame;
    private final InputView inputView;
    private final ResultView resultView;

    public GameController() {
        inputView = new InputView();
        carRepository = new CarRepository();
        resultView = new ResultView();
    }

    public void startGame(Scanner scanner) {
        carRepository.createCars(inputView.inputCarNames(scanner));
        racingGame = new RacingGame(inputView.inputGameTryCnt(scanner));

        System.out.println("\n" + Constant.EXECUTION_RESULT);
        for (int i = 0; i < racingGame.getTryCnt(); i++) {
            play();
            resultView.printStates(carRepository.getCarList());
        }
        resultView.printWinner(getWinner());
    }

    private void play() {
        int[] carRandomNum = new int[carRepository.getCarList().size()];
        for (int i = 0; i < carRepository.getCarList().size(); i++) {
            carRandomNum[i] = RandomUtils.nextInt(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
            checkMove(i, carRandomNum[i]);
        }
    }

    private void checkMove(int carIdx, int randomNum) {
        if (randomNum >= MOVE_THRESHOLD) {
            carRepository.getCarList().get(carIdx).updatePosition();
        }
    }

    private List<String> getWinner() {
        List<String> winnerList = new ArrayList<>();
        int maxPosition = START_POSITION;
        int tmpPosition = carRepository.getCarList().stream()
            .max(Comparator.comparingInt(Car::getPosition))
            .get().getPosition();
        maxPosition = Math.max(maxPosition, tmpPosition);
        int finalMaxPosition = maxPosition;
        carRepository.getCarList().forEach(car -> {
            if(finalMaxPosition == car.getPosition()) {
                winnerList.add(car.getName());
            }
        });
        return winnerList;
    }
}