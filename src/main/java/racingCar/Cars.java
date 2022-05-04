package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    public Cars(int countOfCar) {
        for (int i = 0; i < countOfCar; i++) {
            Car car = new Car();
            this.carList.add(car);
        }
    }

    public Cars(String[] nameList) {
        for (int i = 0; i < nameList.length; i++) {
            Car car = new Car(nameList[i]);
            this.carList.add(car);
        }
    }

    public Cars(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            this.carList.add(cars.get(i));
        }
    }

    public void carMove(int index, int randomNumber) {
        this.carList.get(index).move(randomNumber);
    }

    public int carsSize() {
        return this.carList.size();
    }

    public String carMakePosition(int index) {
        return this.carList.get(index).makePosition();
    }

    public String carMakeNameAndPosition(int index) {
        return this.carList.get(index).makeNameAndPosition();
    }


    public int carsMaxPosition() {
        int maxPosition = this.carList.get(0).currentPosition();
        for (int i = 1; i < this.carList.size(); i++) {
            maxPosition = this.carList.get(i).maxPosition(maxPosition);
        }
        return maxPosition;
    }

    public void isMaxCar(int index, int maxPosition, List<Car> winners) {
        if (this.carList.get(index).isMaxPosition(maxPosition)) {
            winners.add(this.carList.get(index));
        }
    }

    public Winners winnerCars() {
        List<Car> winnerCars = new ArrayList<>();
        int maxPosition = carsMaxPosition();
        for (int i = 0; i < this.carList.size(); i++) {
            isMaxCar(i, maxPosition, winnerCars);
        }
        return new Winners(winnerCars);
    }

}
