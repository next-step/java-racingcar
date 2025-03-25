package racingcar.view;

import java.util.List;

public class OutputView {

    public void askCarNumbers() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void askRoundNumbers() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void printRacingResult(String result) {
        System.out.println("\n실행결과");
        System.out.println(result);
    }

    public void showRace(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}