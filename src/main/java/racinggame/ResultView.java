package racinggame;

import java.util.List;

public class ResultView {

    public void printResultMessage() {
        System.out.println("실행 결과");
    }
    public void printStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getStatus()));
        }
        System.out.println();
    }

    public void printWinner(List<Car> winners) {
        System.out.println(winners + " 최종 우승했습니다.");
    }
}
