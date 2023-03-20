package racingcargame;

import java.util.List;

public class ResultView {

    public void printRace(Car car) {
        System.out.println(car.getName() + " : " + car.getPrintScore());
    }

    public void printRaceResult(String winner) {
        System.out.println("최종 우승자: " + winner);
    }
}
