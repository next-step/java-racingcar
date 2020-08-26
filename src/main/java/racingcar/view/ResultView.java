package racingcar.view;

import racingcar.Car;
import racingcar.Winner;

import java.util.List;

public class ResultView {
    private final String MOVEMENT = "-";
    private Winner winner = new Winner();

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printResult(List<Car> cars) {
        cars.stream()
                .forEach(car -> {
                    int position = car.getPosition();
                    System.out.print(car.getName() + " : ");
                    for(int i = 0; i < position; i++){
                        System.out.print(MOVEMENT);
                    }
                    System.out.println();
                });
        System.out.println();
    }
    public void printWinner(List<Car> cars) {
        System.out.println(winner.findWinner(cars) + "가 최종 우승했습니다.");
    }
}
