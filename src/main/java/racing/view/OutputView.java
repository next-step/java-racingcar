package racing.view;

import racing.domain.Car;

import java.util.List;

public class OutputView {
    public static void display(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("-".repeat(cars.get(i).getDistance()));
        }
    }

    public static void requestCarNum() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void requestRoundNum() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static void showResult() {
        System.out.println("실행결과");
    }

    public static void showRound(int i) {
        System.out.println("******** "+(i+1)+" 라운드 ********");
    }
}
