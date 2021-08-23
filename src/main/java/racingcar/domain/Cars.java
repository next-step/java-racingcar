package racingcar.domain;

import java.util.*;

public class Cars {
    private final static MovingStrategy movingStrategy = new CarMovingStrategy();

    private final List<Car> carList;

    public Cars(String[] carNames) {
        checkValidCarNames(carNames);
        List<Car> list = new ArrayList<>(carNames.length);

        for (String name : carNames) {
            list.add(new Car(name));
        }

        carList = list;
    }

    public Cars(Car[] carInfo) {
        List<Car> list = new ArrayList<>(carInfo.length);

        for (Car car : carInfo) {
            list.add(car);
        }

        carList = list;
    }

    void checkValidCarNames(String[] CarNames) {
        if (CarNames == null || CarNames.length == 0) {
            throw new IllegalArgumentException("유효한 Car Name 들이 아닙니다.");
        }
    }

    public void runOneRound() {
        for (Car car : carList) {
            car.move(movingStrategy);
        }
    }

    Winners calculateWinners() {
        sortByLocation();

        List<Car> winners = new ArrayList<>(carList.size());
        Car firstCar = carList.get(0);

        winners.add(firstCar);
        for (int i = 1; i < carList.size() && carList.get(i).equalsLocation(firstCar); i++) {
            winners.add(carList.get(i));
        }

        return new Winners(winners);
    }

    public void sortByLocation() {
        Collections.sort(carList);
    }


    public String getCarsStateInString() {
        StringBuilder state = new StringBuilder();

        for (Car car : carList) {
            state.append(car.getCarStateInString() + "\n");
        }

        return state.toString();
    }

    public boolean equalsExactly(Cars compared) {
        if (carList.size() != compared.carList.size()) {
            return false;
        }

        boolean result = true;
        Iterator<Car> originIter = carList.listIterator();
        Iterator<Car> comparedIter = compared.carList.listIterator();

        while (originIter.hasNext()) {
            result &= originIter.next().equals(comparedIter.next());
        }

        return result;
    }

    boolean contains(Car element) {
        boolean result = false;
        for (Car car : carList) {
            result |= car.equals(element);
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cars == false) {
            return false;
        }

        Cars compared = (Cars) o;
        if (carList.size() != compared.carList.size()) {
            return false;
        }

        boolean result = true;
        for (Car car : compared.carList) {
            result &= contains(car);
        }

        return result;
    }
}
