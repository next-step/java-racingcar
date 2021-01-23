package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Game {

    private int gameCnt;
    private List<Car> carList;

    public Game(int cnt, List<Car> carList) {
        this.gameCnt = cnt;
        this.carList = carList;
    }

    public void start() {
        PrintUtils.printExecutionResult();
        for (int i = 0; i < gameCnt; i++) {
            play();
            print();
        }
        PrintUtils.printWinner(getWinner());
    }

    private List<String> getWinner() {
        Optional<Car> maxPositionCar = carList
            .stream()
            .max((a, b) -> Integer.compare(a.getPosition(), b.getPosition()));
        return returnWinner(maxPositionCar.get().getPosition());
    }

    private List<String> returnWinner(final int winnerThreshold) {
        List<String> winnerList = new ArrayList<>();
        carList
            .stream()
            .filter(car -> winnerThreshold == car.getPosition())
            .forEach(winner -> winnerList.add(winner.getName()));
        return winnerList;
    }

    private void print() {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).printCarState();
        }
        System.out.println();
    }

    private void play() {
        int[] carRandomNum = new int[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            carRandomNum[i] = RandomUtils
                .nextInt(Constant.RANDOM_START_INCLUSIVE, Constant.RANDOM_END_INCLUSIVE);
            checkMove(i, carRandomNum[i]);
        }
    }

    private void checkMove(int carIdx, int randomNum) {
        if (randomNum >= Constant.MOVE_THRESHOLD) {
            carList.get(carIdx).updatePosition();
        }
    }
}
