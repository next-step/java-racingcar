package view;

import domain.CarInfo;

import java.util.List;

public class ResultView {

    public static void printCars(List<CarInfo> car) {
        for (CarInfo element : car) {
            System.out.println(element.getCarName() + " : " + element.getCarStatus());
        }
        System.out.println("\n");
    }
}
