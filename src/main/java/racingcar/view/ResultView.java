package racingcar.view;

import racingcar.service.Car;

import java.util.List;

public class ResultView {

    public static void view(List<Car> cars) {
        System.out.println();
        System.out.println("실행 결과");

        if (cars.size() == 0 || cars.get(0).getState().size() == 0) {
            System.out.println("레이스가 실행되지 않았습니다.");
            return;
        }

        int labs = cars.get(0).getState().size();
        for (int lab = 0; lab < labs; lab++) {
            viewCarsInLab(cars, lab);
            System.out.println();
        }
    }

    private static void viewCarsInLab(List<Car> cars, int lab) {
        for (int car = 0; car < cars.size(); car++) {
            System.out.println(cars.get(car).getName() + " : " + "-".repeat(cars.get(car).getState().get(lab)));
        }
    }

    public static void viewWinners(String winnerNames) {
        if (winnerNames.length() == 0) {
            return;
        }

        System.out.print(winnerNames + "가 최종 우승했습니다.");
    }
}
