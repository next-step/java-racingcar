package step3.view;

import step3.domain.Car;

import java.util.List;

public class ResultView {

    public void printRacingLog(String racingLog) {
        System.out.println(racingLog);
    }

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자는 ");
        winners.forEach(winner -> System.out.print(winner + ","));
        System.out.println(" 입니다.");
    }

}
