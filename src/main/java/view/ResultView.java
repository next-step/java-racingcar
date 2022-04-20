package view;

import domain.car.Car;
import domain.car.CarRacingGame;

import java.util.List;

public class ResultView {
    private CarRacingGame racing;

    public ResultView(CarRacingGame racing) {
        this.racing = racing;
    }

    public void print(List<Car> winners) {
        for (Car winner : winners) {
            System.out.print(winner.getName() + " ");
        }
        System.out.println("최종 우승했습니다.");
    }
}
