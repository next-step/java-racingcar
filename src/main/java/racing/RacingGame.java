package racing;

import java.util.ArrayList;
import java.util.List;

import static racing.utils.RandomNumber.makeOneRandomNumber;
import static racing.view.Input.makeGameRepeatCount;
import static racing.view.Input.makeCarNames;
import static racing.view.Output.*;

public class RacingGame {
    public static String SEPARATOR = ",";

    public void gameStart() {
        printStartMessage();
        String carNames = makeCarNames();
        printInputCountMessage();
        int count = makeGameRepeatCount();
        printResultMessage();

        String[] carNameArray = carNames.split(SEPARATOR);
        List<Car> carList = makeCarList(carNameArray);

        repeatMoveCars(count, carList);
        printWinMessage(findWinner(carList));
    }

    private List<Car> makeCarList(String[] carNameArray) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameArray) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    private void repeatMoveCars(int count, List<Car> carList) {
        for (int i = 0; i < count; i++) {
            moveCars(carList);
        }
    }

    private void moveCars(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(makeOneRandomNumber());
        }
        printNowDistance(carList);
    }

    private List<String> findWinner(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        int winnerCondition = findWinnerCondition(carList);
        for (Car car : carList) {
            if (car.getMoveCount() == winnerCondition) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private int findWinnerCondition(List<Car> carList) {
        int winnerCondition = 0;
        for (Car car : carList) {
            if (car.getMoveCount() >= winnerCondition) {
                winnerCondition = car.getMoveCount();
            }
        }
        return winnerCondition;
    }
}