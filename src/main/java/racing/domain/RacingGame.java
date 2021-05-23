package racing.domain;

import racing.utils.ConvertString;
import racing.utils.RandomNumber;
import racing.view.Input;
import racing.view.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final String NAME_LENGTH_OVER = "이름은 5자 이내로 입력하세요.";

    private void makeCar(String name, List<Car> carList) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_OVER);
        }
        Car car = new Car(name);
        car.init();
        carList.add(car);
    }

    public void gameStart() {
        RacingGame racingGame = new RacingGame();
        Output output = new Output();
        Input input = new Input();
        ConvertString convertString = new ConvertString();
        List<Car> carNames;

        output.printStart();
        String carString = input.makeCars();
        output.count();
        int count = input.count();
        output.result();
        String[] carNameArray = convertString.splitString(carString);
        carNames = makeCarList(carNameArray);
        repeatMoveCount(carNames, count);
        output.win(findWinner(carNames));
    }

    private void repeatMoveCount(List<Car> carList, int count) {
        Output output = new Output();
        for (int i = 0; i < count; i++) {
            moveCountChange(carList);
            output.printCarDistance(carList);
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
        RandomNumber randomNumber = new RandomNumber();
        return randomNumber.makeRandomNumber();
    }

    private void moveCountChange(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(makeRandomNumber());
        }
    }

    /*
    저번 우승자 리스트 찾는 함수에 비해서 더 세분화 되긴 했는데
    자동차 리스트 iterator 때문에 depth가 2가 되었네요....
    혹시 더 좋은 방법이 있을까요...?
     */
    private List<String> findWinner(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        int winnerCount = findMaxMoveCount(carList);
        return findCorrespondMoveCountCarNames(carList, winnerCount);
    }

    private int findMaxMoveCount(List<Car> carList) {
        int maxMoveCount = 0;

        for (Car car : carList) {
            if (car.getMoveCount() > maxMoveCount) {
                maxMoveCount = car.getMoveCount();
            }
        }
        return maxMoveCount;
    }

    private List<String> findCorrespondMoveCountCarNames(List<Car> carList, int moveCount) {
        List<String> correspondCarNames = new ArrayList<>();
        for (Car car : carList) {
            if (car.getMoveCount() == moveCount)
                correspondCarNames.add(car.getName());
        }
        return correspondCarNames;
    }
}