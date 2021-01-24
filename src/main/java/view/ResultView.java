package view;

import domain.Car;

public class ResultView {
    public static void printStartSign() {
        System.out.println("실행 결과");
    }

    public static void printCarStatus(Car car){
        System.out.print(car.getName()+" : ");
        for (int i=0; i<car.getStatus(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
