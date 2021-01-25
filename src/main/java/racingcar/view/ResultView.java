package racingcar.view;

import racingcar.domain.CarDomain;

import java.util.ArrayList;

public class ResultView {
    public static void printCurrentCarsState(ArrayList<CarDomain> carsList) {
        System.out.println("\n실행 결과");
        for (CarDomain carDomain : carsList) {
            printCarInfo(carDomain);
        }
    }

    private static void printCarInfo(CarDomain carDomain) {
        StringBuffer carInfo = new StringBuffer();
        carInfo.append(carDomain.getName());
        carInfo.append(" : ");
        for (int i = 0; i < carDomain.getDistance(); ++i) {
            carInfo.append("-");
        }
        System.out.println(carInfo);
    }

    public static void printWinners(ArrayList<CarDomain> carsList, int maxDistance) {
        System.out.print("최종 우승자 : ");
        for (CarDomain carDomain : carsList) {
            printWinner(carDomain, maxDistance);
        }
        System.out.println("");
    }

    private static void printWinner(CarDomain carDomain, int maxDistance) {
        if (carDomain.getDistance() == maxDistance) {
            System.out.print(carDomain.getName() + " ");
        }
    }
}
