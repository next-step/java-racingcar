package step3.model;

import java.util.ArrayList;

public class CarList {

    public static ArrayList<String> makeCarList(Integer countOfCar) {
        ArrayList<String> carList = new ArrayList<>();
        for (int i = 0; i < countOfCar; i++) {
            carList.add("-");
        }
        return carList;
    }
}
