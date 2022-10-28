package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfCars = inputNumberOfCars(scanner);
        int countRound = inputCountRound(scanner);

        RacingCarList racingCarList = new RacingCarList(numberOfCars);

        for (int i = 0; i < countRound; i++) {
            allRacingCarGoingAheadOrNotInRound(racingCarList);
            allRacingCarPrintInRound(racingCarList);
        }
    }

    public static void allRacingCarGoingAheadOrNotInRound(RacingCarList racingCarList) {
        for (RacingCar racingCar : racingCarList.list()) {
            eachRacingCarGoingAheadOrNot(racingCar);
        }
    }

    public static void eachRacingCarGoingAheadOrNot(RacingCar racingCar) {
        if (racingCar.goingAheadOrNot(new RandomBounded())) {
            racingCar = racingCar.goAhead();
        }
    }

    public static int inputNumberOfCars(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대인가요?");
        return inputInteger(scanner);
    }

    public static int inputCountRound(Scanner scanner) {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return inputInteger(scanner);
    }

    public static int inputInteger(Scanner scanner){
        return scanner.nextInt();
    }

    public static void allRacingCarPrintInRound(RacingCarList racingCarList) {
        for (RacingCar racingCar : racingCarList.list()) {
            eachRacingCarPrint(racingCar.position());
        }
        System.out.println();
    }

    public static void eachRacingCarPrint(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
