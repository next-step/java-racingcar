package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {
    private final String MOVEMENT = "-";

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printResult(List<Car> cars) {
        cars.stream()
                .forEach(car -> {
                    int position = car.getPosition();
                    for(int i = 0; i < position; i++){
                        System.out.print(MOVEMENT);
                    }
                    System.out.println();
                });
        System.out.println();
    }
}
