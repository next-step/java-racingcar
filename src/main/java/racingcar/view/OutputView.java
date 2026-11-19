package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.dto.RacingGameDto;

import java.util.List;

public class OutputView {


    public static void printResultMessage() {
        System.out.println("실행 결과");
    }



    public static void printRoundResult(RacingGameDto results) {
        for (CarDto result : results.getResult()) {
            System.out.print(result.getName() + " : ");
            System.out.println("-".repeat(result.getPosition()));
        }
        System.out.println();
    }


}
