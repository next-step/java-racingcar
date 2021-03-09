package racingcar.model;

import racingcar.model.action.RandomMovable;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CarRacingInformation {
    private ArrayList<Car> carList;
    private RandomMovable randomMovable;
    private int carRacingCount;


    public CarRacingInformation(List<String> carNameList, int carRacingCount) {
        checkDuplication(carNameList);
        isZeroOrLess(carRacingCount);
        this.carList = makeCarList(carNameList);
        randomMovable = new RandomMovable();
        this.carRacingCount = carRacingCount;
    }

    private void checkDuplication(List<String> carNameList) {
        Set<String> nonDuplicatedCarNameList = new HashSet<>(carNameList);

        if(nonDuplicatedCarNameList.size() != carNameList.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복되서 입력할 수 없습니다.");
        }
    }


    private ArrayList<Car> makeCarList(List<String> carNameList) {
        carList = new ArrayList<>(carNameList.size());
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public void isZeroOrLess(int number) {
        if (number <= 0 ) {
            throw new IllegalArgumentException("입력값이 0 이하입니다.");
        }
    }


    public ArrayList<Car> getCarList() {
        return carList;
    }


    public ArrayList<Car> decideMovable() {
        carList.stream()
                .forEach(car -> decideMovableByRandomValue(car));

        return carList;
    }

    public void decideMovableByRandomValue(Car car) {
        int randomValue = randomMovable.makeRandomValue();
        if (randomMovable.moveOrNot(randomValue)) {
            car.move();
        }
    }

    public boolean checkCarRacingCount() {
        return carRacingCount > 0;
    }

    public void minusCarRacingCount() {
        carRacingCount--;
    }


    public int getCarRacingCount() {
        return carRacingCount;
    }

    public List<String> setWinner() {
        int winnerPoisiton = carList.stream()
                .max(Comparator.comparing(Car::getPoisition))
                .get()
                .getPoisition();

        return carList.stream()
                .filter(car -> car.getPoisition() == winnerPoisiton)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
