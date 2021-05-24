package racing.domain;

import racing.utils.ConvertString;
import racing.utils.RandomNumber;
import racing.view.Input;
import racing.view.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private void makeCar(String name, List<Car> cars) {
        Car car = new Car(name);
        cars.add(car);
    }

    public void gameStart() {

        Output.printStart();
        String carNames = Input.carNames();
        Output.count();
        int count = Input.gameCount();
        Output.result();
        String[] carNameArray = ConvertString.splitString(carNames);
        List<Car> cars = makeCars(carNameArray);
        repeatMoveCount(cars, count);
        Output.win(findWinner(cars));
    }

    private void repeatMoveCount(List<Car> cars, int count) {

        for (int i = 0; i < count; i++) {
            moveCountChange(cars);
            Output.printCarDistance(cars);
        }
    }

    private List<Car> makeCars(String[] carNameArray) {
        List<Car> cars = new ArrayList<Car>();
        for (String carName : carNameArray) {
            makeCar(carName, cars);
        }
        return cars;
    }

    private int makeRandomNumber() {
        return RandomNumber.makeRandomNumber();
    }

    private void moveCountChange(List<Car> cars) {
        int carsSize = cars.size();
        for (int i = 0; i < carsSize; i++) {
            cars.get(i).move(makeRandomNumber());
        }
    }

    /*
    저번 우승자 리스트 찾는 함수에 비해서 더 세분화 되긴 했는데
    자동차 리스트 iterator 때문에 depth가 2가 되었네요....
    혹시 더 좋은 방법이 있을까요...?
     */
    private List<String> findWinner(List<Car> cars) {
        List<String> winnerList = new ArrayList<>();
        int winnerCount = findMaxMoveCount(cars);
        return findCorrespondMoveCountCarNames(cars, winnerCount);
    }

    private int findMaxMoveCount(List<Car> cars) {
        int maxMoveCount = 0;

        for (Car car : cars) {
            if (car.getMoveCount() > maxMoveCount) {
                maxMoveCount = car.getMoveCount();
            }
        }
        return maxMoveCount;
    }

    private List<String> findCorrespondMoveCountCarNames(List<Car> cars, int moveCount) {
        List<String> correspondCarNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMoveCount() == moveCount)
                correspondCarNames.add(car.getName());
        }
        return correspondCarNames;
    }
}