package thirdstep.view;

import thirdstep.logic.Car;

import java.util.ArrayList;

public class ResultView {

    public static void printOneRace(ArrayList<Car> carArrayList) {
        for (Car car : carArrayList) {
            System.out.println(car.getCarLocation());
        }
        System.out.println();
    }
}
