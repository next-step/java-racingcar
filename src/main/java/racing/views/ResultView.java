package racing.views;

import racing.domain.Car;

import java.util.List;

public class ResultView {
    public static void showResult(){
        System.out.println("실행 결과");
    }

    public static void showRaceRound(List<Car> cars) {
        cars.forEach(car ->
                System.out.println(car.getName() + " : " + car.getAdvanceProgress()));
        System.out.println();
    }

    public static void showWinners(List<String> winnerNames) {
        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }
}
