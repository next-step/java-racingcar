package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racingcar.domain.ErrorMessage.IS_NOT_TRY_COUNT;

public class Race {
    private static final int RANDOM_SIZE = 10;
    private List<Car> carList = new ArrayList<>();
    private int tryCount;
    private int maxDistance;

    public Race(String[] carNameList, int tryCount) {
        validateTryCount(tryCount);
        makeRacingCar(carNameList);
        this.tryCount = tryCount;
        this.maxDistance = 0;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<Car> getCarList() {
        return carList;
    }


    public void carMove() {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).goCar(getRandomNum());
        }

    }



    private void makeRacingCar(String[] carNameList) {
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    public static void validateTryCount(int num) {
        if(num<1){
            throw new IllegalArgumentException(IS_NOT_TRY_COUNT);
        }
    }

    public void setMaxDistance() {
        for (Car car : carList) {
            maxDistance = car.compareDistance(maxDistance);
        }
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public List<String> getWinnerCarNames(){
        List<String> winnerNames = new ArrayList<>();
        for (Car car : getWinnerCarList()) {
            winnerNames.add(car.getCarName());
        }
        return winnerNames;
    }

    private List<Car> getWinnerCarList() {
        setMaxDistance();
        List<Car> winnerCarList = new ArrayList<>();
        for (Car car : carList) {
            addWinner(winnerCarList, car);
        }
        return winnerCarList;
    }

    public void addWinner(List<Car> winnerCarList, Car car) {
        if (car.isWinnerCar(maxDistance)) {
            winnerCarList.add(car);
        }
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(RANDOM_SIZE);
    }

}
