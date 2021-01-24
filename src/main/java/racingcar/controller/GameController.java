package racingcar.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.repository.CarRepository;
import racingcar.util.Constant;
import racingcar.util.RandomUtils;

public class GameController {
    static final int START_POSITION = 0;
    static final int MOVE_THRESHOLD = 4;
    static final int RANDOM_START_INCLUSIVE = 0;
    static final int RANDOM_END_INCLUSIVE = 9;

    private CarRepository carRepository;
    private RacingGame racingGame;

    public GameController(CarRepository carRepository, RacingGame racingGame) {
        this.carRepository = carRepository;
        this.racingGame = racingGame;
    }

    public List<String> playGame() {
        System.out.println("\n" + Constant.EXECUTION_RESULT);
        for (int i = 0; i < racingGame.getTryCnt(); i++) {
            play();
            printStates();
        }
        return getWinner();
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

    private void printStates() {
        carRepository.getCarList().forEach(car -> {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        });
        System.out.println();
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