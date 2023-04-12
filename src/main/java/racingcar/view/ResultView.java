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

        int races = cars.get(0).getState().size();
        for (int race = 0; race < races; race++) {
            for (int car = 0; car < cars.size(); car++) {
                System.out.println("-".repeat(cars.get(car).getState().get(race)));
            }
            System.out.println();
        }
    }

}
