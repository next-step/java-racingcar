package study.racingCar;

public class CarList {

    private Car[] carList;

    public CarList(int carNums) {
        this.carList = new Car[carNums];
        for (int i = 0; i < carNums; i++) {
            carList[i] = new Car();
        }
    }

    public Car getCar(int idx) {
        return carList[idx];
    }
}
