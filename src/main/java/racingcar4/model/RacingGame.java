package racingcar4.model;

import java.util.*;


//레이싱 게임을 주도
public class RacingGame {
    private final List<Car> cars;

    public RacingGame(String nameOfCars) {
        String[] nameOfCarsList = splitNames(nameOfCars);
        nameOfCarsList = removeOverlap(nameOfCarsList);
        this.cars = new ArrayList<>(nameOfCarsList.length);
        for (String name : nameOfCarsList) {
            cars.add(new Car(name));
        }
    }

    //자동차이름 중복 제거
    private String[] removeOverlap(String[] names) {
        Set<String> setNames = new HashSet<>(Arrays.asList(names));
        return setNames.toArray(new String[0]);
    }

    //한턴 진행
    public void oneTurn() {
        for (Car car:cars) {
            car.carTurn(RandomNumber.getNumber());
        }
    }

    //자동차 이름 split 진행
    private String[] splitNames(String names) {
        return names.split(",");
    }

    //한턴이 끝난후 자동차 현재위치 출력
    public void resultCar() {
        for (Car car :cars) {
            car.getStatus();
        }
    }

    public List<String> victoryCars() {
        List<String> names =  new ArrayList<>();
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }

        for (Car car : cars) {
            victoryCars(maxPosition, car, names);
        }
        return names;
    }

    private void victoryCars(int maxPosition, Car car, List<String> names) {
        if (car.victoryCar(maxPosition)) {
            names.add(car.getName());
        }
    }
}
