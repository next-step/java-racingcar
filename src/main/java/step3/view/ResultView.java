package step3.view;

import step3.car.Car;

import java.util.List;

public class ResultView {

    public void showCommentForGettingCarNumber() {
        System.out.print("자동차 대수는 몇 대 인가요? : ");
    }

    public void showCommentForGettingRoundNumber() {
        System.out.print("시도할 회수는 몇 회 인가요? : ");
    }

    public void showGameResultComment() {
        System.out.println("\n 실행 결과");
    }

    public void showRoundResult(int roundNumber, List<Car> cars) {
        System.out.println("Round : " + roundNumber);
        for (Car car : cars) {
            System.out.printf("[%3d] %s%n", car.getPosition(), "-".repeat(car.getPosition()));
        }
        System.out.println();

    }
}
