package study.step4;

import study.step4.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private static final char POSITION_MARK = '-';
    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getPositionStr(car));
        }
        System.out.println();
    }

    public void printInit(List<Car> cars) {
        System.out.println("\n실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getPositionStr(car));
        }
        System.out.println();
    }

    public void printWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            winners.add(car.getName());
        }
        String winnerStr = String.join(", ", winners);

        System.out.println(winnerStr + "가 최종 우승했습니다.");
    }
    private String getPositionStr(Car car) {
        StringBuilder positionStr = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            positionStr.append(POSITION_MARK);
        }
        return positionStr.toString();

    }

}
