package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.RoundResult;

import java.util.List;

public class OutputView {


    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCurrentPosition(RoundResult roundResult) {
        for (int position : roundResult.getPosition()) {
            System.out.println("-".repeat(position));
        }
        System.out.println();
    }


}
