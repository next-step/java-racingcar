package com.cheolhyeonpark.step4;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    public static final String GAME_RESULT = "실행결과";
    public static final String POSITION_BAR = "-";

    public void printResultTitle() {
        System.out.println(GAME_RESULT);
    }

    public void printStageResult(List<Car> cars) {
        cars.forEach(this::printPosition);
        System.out.println();
    }

    public void printPosition(Car car) {
        System.out.print(car.getName() + " : ");
        IntStream.range(0, car.getPosition()).mapToObj(i -> POSITION_BAR).forEach(System.out::print);
        System.out.println();
    }
}
