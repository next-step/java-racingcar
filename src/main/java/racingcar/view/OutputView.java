package racingcar.view;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static void PrintWinner(List<Car> winners) {
        List<String> winnersName = new ArrayList<>();
        for (Car winner : winners) {
            winnersName.add(winner.getName());
        }
        System.out.println(String.join(",", winnersName) + "가 우승자 입니다.");
    }
}
