package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    /**
     * @param cars
     * 결과 출력
     */
    public static void showResult(List<Car> cars) {
        for (Car car: cars) {
            drawDash(car);
            System.out.println();
        }
    }

    /**
     * @param car
     * 차량 현재 위치를 그린다.
     */
    private static void drawDash(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(" : ");

        for (int j = 0; j< car.getPosition(); j++) {
            sb.append("-");
        }

        System.out.print(sb.toString());
    }

    public static void showWinners(String winners) {
        System.out.println(winners+"가 최종 우승했습니다.");
    }
}
