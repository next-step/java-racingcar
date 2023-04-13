package study.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final ResultView resultView = new ResultView();
    private static final int DEFAULT_MIN = 0;
    private static final int DEFAULT_MAX = 9;
    private boolean isReady = false;
    private boolean isEnd = false;
    private List<Car> carList;

    public void readyGame(String carNameList) {
        String[] names = carNameList.split(",");
        carList = new ArrayList<>();

        for (String name : names) {
            carList.add(new Car(name));
        }
        isReady = true;
    }

    public void startGame(int tryCount) {
        if (!isReady) {
            resultView.isNotReadyMsg();
            return;
        }
        resultView.startMsg();
        for (int i = 0; i < tryCount; i++) {
            movingCars();
            resultView.endingRoundMsg(i + 1);
        }
        isEnd = true;
    }

    private void movingCars() {
        for (Car car : carList) {
            int randNum = RandomUtil.makeRandomNumber(DEFAULT_MIN, DEFAULT_MAX);
            if (car.canMove(randNum)) car.move();
            resultView.moveResult(car);
        }
    }

    public void getWinner() {
        if (!isEnd) {
            resultView.isNotEndMsg();
            return;
        }
        List positonList = carList.stream().map(Car::getPosition).collect(Collectors.toList());
        List nameList = carList.stream().map(Car::getName).collect(Collectors.toList());
        List[] ranks = RankUtil.ranking(positonList, nameList);

        resultView.getWinnerResult(ranks[0]);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
