package racing;

import racing.utils.ConvertString;
import racing.utils.RandomNumber;

import java.util.ArrayList;
import java.util.List;

import static racing.utils.RandomNumber.makeOneRandomNumber;
import static racing.view.Input.makeGameRepeatCount;
import static racing.view.Input.makeCarString;
import static racing.view.Output.*;

public class RacingGame {

    public void gameStart() {
        ConvertString convertString = new ConvertString();

        printStartMessage();
        String carString = makeCarString();
        printCount();
        int count = makeGameRepeatCount();
        printResult();

        String[] carNameArray = convertString.splitStrings(carString);
        List<Car> carList = makeCarList(carNameArray);
        repeatMoveCountChange(count, carList);
        printWinMessage(findWinner(carList));
    }

    private List<Car> makeCar(String name, List<Car> carList) {
        Car car = new Car(name);
        carList.add(car);
        return carList;
    }

    private void repeatMoveCountChange(int count, List<Car> carList) {
        for (int i = 0; i < count; i++) {
            moveCountChange(carList);
            printNowDistance(carList);
        }
    }

    private List<Car> makeCarList(String[] carNameArray) {
        List<Car> carList = new ArrayList<Car>();

        for (String carName : carNameArray) {
            makeCar(carName, carList);
        }
        return carList;
    }

    private int makeRandomNumber() {
        return makeOneRandomNumber();
    }

    private void moveCountChange(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(makeRandomNumber());
        }
    }

    private List<String> findWinner(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        int winnerCount = 0;

        for (int i = 0; i < carList.size(); i++) {
            winnerCount = findWinnerCount(carList.get(i), winnerCount, winnerList);
        }
        return winnerList;
    }

    private int findWinnerCount(Car car, int winnerCount, List<String> winnerList) {
        if (car.getMoveCount() == winnerCount) {
            winnerList.add(car.getName());
        }
        if (car.getMoveCount() > winnerCount) {
            winnerList.clear();
            winnerCount = car.getMoveCount();
            winnerList.add(car.getName());
        }
        return winnerCount;
    }
}