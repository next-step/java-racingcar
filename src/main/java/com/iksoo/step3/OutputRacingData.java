package com.iksoo.step3;

public class OutputRacingData {
    public void printBlankLine() {
        System.out.println();
    }

    public void printFinalResult(Car[] car, int tryOfNumber) {
        System.out.println("실행 결과");

        for (int i = 0; i < tryOfNumber; i++) {
            printAllCharactor(car);
        }
    }

    public void printAllCharactor(Car[] car) {
        for (int i = 0; i < car.length; i++) {
            printCarResult(car[i].getCarName(), car[i].getCarPosition());
        }
        printBlankLine();
    }

    public void printCarResult(String carName, int carPosition) {
        System.out.print(carName + " : ");
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        printBlankLine();
    }
}
