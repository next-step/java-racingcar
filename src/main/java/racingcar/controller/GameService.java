package racingcar.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.util.Constant;
import racingcar.util.RandomUtils;
import racingcar.domain.Car;

public class Game {

    static final int START_POSITION = 0;
    static final int MOVE_THRESHOLD = 4;
    static final int RANDOM_START_INCLUSIVE = 0;
    static final int RANDOM_END_INCLUSIVE = 9;
    private int gameCnt = 0;
    private List<Car> carList;

    public Game(int cnt, List<Car> carList) {
        this.gameCnt = cnt;
        this.carList = carList;
    }

    public void start() {
        System.out.println("\n" + Constant.EXECUTION_RESULT);
        for (int i = 0; i < gameCnt; i++) {
            play();
            printStates();
        }
        printWinner();
    }

    private void printWinner() {
        List<String> winnerList = getWinner();
        System.out.print(Constant.FINAL_WINNER);
        System.out.println(String.join(", ", winnerList));
    }

    private List<String> getWinner() {
        List<String> winnerList = new ArrayList<>();
        int maxPosition = START_POSITION;
        int tmpPosition = carList.stream()
            .max(Comparator.comparingInt(Car::getPosition))
            .get().getPosition();
        maxPosition = Math.max(maxPosition, tmpPosition);
        int finalMaxPosition = maxPosition;
        carList.forEach(car -> {
            if(finalMaxPosition == car.getPosition()) {
                winnerList.add(car.getName());
            }
        });
        return winnerList;
    }

    private void printStates() {
        carList.forEach(Car::printCarState);
        System.out.println();
    }

    private void play() {
        int[] carRandomNum = new int[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            carRandomNum[i] = RandomUtils.nextInt(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
            checkMove(i, carRandomNum[i]);
        }
    }

    private void checkMove(int carIdx, int randomNum) {
        if (randomNum >= MOVE_THRESHOLD) {
            carList.get(carIdx).updatePosition();
        }
    }
}
