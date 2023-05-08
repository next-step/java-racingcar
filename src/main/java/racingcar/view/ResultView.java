package racingcar.view;

import racingcar.dto.Cars;

public class ResultView {

    private ResultView() {
        throw new AssertionError();
    }

    public static void view(Cars cars) {
        System.out.println();
        System.out.println("실행 결과");

        if (cars.getCars().size() == 0 || cars.getCars().get(0).getState().size() == 0) {
            System.out.println("레이스가 실행되지 않았습니다.");
            return;
        }

        int labs = cars.getCars().get(0).getState().size();

        for (int lab = 0; lab < labs; lab++) {
            viewCarsInLab(cars, lab);
            System.out.println();
        }
    }

    private static void viewCarsInLab(Cars cars, int lab) {
        for (int car = 0; car < cars.getCars().size(); car++) {
            System.out.println(cars.getCars().get(car).getName() + " : " + "-".repeat(cars.getCars().get(car).getState().get(lab)));
        }
    }

    public static void viewWinners(String winnerNames) {
        if (winnerNames.length() == 0) {
            return;
        }

        System.out.print(winnerNames + "가 최종 우승했습니다.");
    }
}
