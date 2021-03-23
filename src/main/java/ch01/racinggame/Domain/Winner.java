package ch01.racinggame.Domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Winner {

    private List<Car> winnerCars;

    public Winner(Car[] cars) {
        winnerCars = new ArrayList<>();
        findWinners(cars);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car winnerCar : this.winnerCars) {
            sb.append(winnerCar.name() + ", ");
        }
        return sb.toString().length() > 0 ? sb.substring(0, sb.length() - 2) : "";
    }

    public List<Car> winnerCars() {
        return this.winnerCars;
    }


    private void saveWinners(Car car, int winnerProgressCnt) {
        if (car.progressCnt() == winnerProgressCnt) {
            this.winnerCars.add(car);
        }
    }

    private int findBigProgreeCnt(Car[] cars) {
        int[] indexArr = new int[cars.length];
        for (int i = 0; i < cars.length; i++) {
            indexArr[i] = cars[i].progressCnt();
        }
        Arrays.sort(indexArr);
        return indexArr[indexArr.length - 1];

    }

    private void findWinners(Car[] cars) {

        //Collections.sort(winnerCars);
        int bigProgreeCnt = findBigProgreeCnt(cars);

        for (int i = 0; i < cars.length; i++) {
            saveWinners(cars[i], bigProgreeCnt);
        }
    }
}
