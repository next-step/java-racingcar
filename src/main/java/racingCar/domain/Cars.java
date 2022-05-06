package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public Cars(int countOfCar) {
        for (int i = 0; i < countOfCar; i++) {
            Car car = new Car();
            carList.add(car);
        }
    }

    public Cars(String[] nameList) {
        for (int i = 0; i < nameList.length; i++) {
            Car car = new Car(nameList[i]);
            carList.add(car);
        }
    }

    public Cars(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car temporaryCar = cars.get(i);
            carList.add(temporaryCar);
        }
    }

    public void carMove(int index, int randomNumber) {
        Car temporaryCar = carList.get(index);
        temporaryCar.move(randomNumber);
    }

    public String carMakeNameAndPosition(int index) {
        Car temporaryCar = carList.get(index);
        return temporaryCar.makeNameAndPosition();
    }

    public Position carsMaxPosition() {
        Position maxPosition = new Position(0);
        for (int i = 0; i < carList.size(); i++) {
            Car temporaryCar = carList.get(i);
            maxPosition = temporaryCar.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    public void isMaxCar(Car car, Position maxPosition, List<Car> winners) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car);
        }
    }

    public Winners findWinners() {
        List<Car> winnerCars = new ArrayList<>();
        Position maxPosition = carsMaxPosition();
        for (int i = 0; i < carList.size(); i++) {
            isMaxCar(carList.get(i), maxPosition, winnerCars);
        }
        return new Winners(winnerCars);
    }

}
