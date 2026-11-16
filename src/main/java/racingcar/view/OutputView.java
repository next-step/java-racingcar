package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {


    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCurrentPosition(List<Integer> positions) {
        for (int position : positions) {
            System.out.println("-".repeat(position));
        }
        System.out.println();
    }


}
