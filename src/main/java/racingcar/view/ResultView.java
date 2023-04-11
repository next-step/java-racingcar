package racingcar.view;

import racingcar.service.RacingCar;

import java.util.List;

public class ResultView {

    public static void view(List<RacingCar> racingCars) {
        System.out.println();
        System.out.println("실행 결과");

        if (racingCars.size() == 0 || racingCars.get(0).getState().size() == 0) {
            System.out.println("레이스가 실행되지 않았습니다.");
            return;
        }

        int races = racingCars.get(0).getState().size();
        for (int race = 0; race < races; race++) {
            for (int car = 0; car < racingCars.size(); car++) {
                System.out.println("-".repeat(racingCars.get(car).getState().get(race)));
            }
            System.out.println();
        }
    }

}
