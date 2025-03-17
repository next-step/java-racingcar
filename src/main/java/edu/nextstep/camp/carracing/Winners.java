package edu.nextstep.camp.carracing;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private Winners() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static List<String> getWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = getMaxPositionCars(cars, maxPosition);
        ResultView.printWinners(winners);
        return winners;
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private static List<String> getMaxPositionCars(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(maxPosition, winners, car);
        }
        return winners;
    }

    private static void addWinner(int maxPosition, List<String> winners, Car car) {
        if (car.isMaxPosition(maxPosition)) {
            winners.add(car.getName().getName());
        }
    }
}
