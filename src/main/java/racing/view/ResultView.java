package racing.view;

import racing.domain.Car;
import racing.domain.RaceInfo;
import racing.domain.Racing;

import java.util.*;

public class ResultView {

    public ResultView() {
    }

    public void status(List<Car> cars, RaceInfo raceInfo) {
        for (int i = 0; i < raceInfo.trialData(); i++) {
            for (Car car : cars) {
                System.out.println(car.carName() + ": " + position(car.carStatus().get(i)));
            }
            System.out.println();
        }
    }

    private String position(int distance) {
        return "-".repeat(Math.max(0, distance));
    }

    public void raceResult(List<Car> cars) {
        String winners = new Racing().winner(cars).toString();
        System.out.println(winners.substring(1, winners.length() - 1) + "가 최종 우승하였습니다.");
    }
}
