package racingcar;

public class Cars {


    public String[] carNames(String carNames) {
        String[] carList = carNames.split(",");
        return carList;
    }

    public boolean carNameLength(String carNames) {
        if (carNames.length() >= 6) {
            return false;
        }
        return true;
    }

    public int createCars(String[] carList) {
        int carCount = 0;
        for (int i = 0; i < carList.length; i++) {
            Car car = new Car(carList[i], 0);
            carCount++;
        }
        return carCount;
    }
}
