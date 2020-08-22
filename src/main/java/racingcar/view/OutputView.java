package racingcar.view;

import racingcar.domain.Cars;

public class OutputView {
    public static void printCarStatus(Cars cars) {
        cars.getCars().forEach(car -> {
            StringBuilder track = new StringBuilder();
            track.append(car.getName().getName()).append(" : ");
            for(int i=1; i <= car.getPosition(); i++) {
                track.append("-");
            }
            System.out.println(track);
        });
    }

    public static void resultView(Cars cars) {
        System.out.println("실행 결과");
        System.out.println(cars.findWinners().createWinnerNames() + "(이)가 최종 우승했습니다.");
    }
}
