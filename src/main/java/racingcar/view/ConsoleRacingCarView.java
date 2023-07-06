package racingcar.view;

import java.util.Scanner;

public class ConsoleRacingCarView implements RacingCarView {

    private final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String COUNT_PROMPT = "시도할 회수는 몇회인가요?";
    private final String PLAY_RESULT = "\n실행 결과\n";
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void printCarNamesPrompt() {
        System.out.println(CAR_NAMES_PROMPT);
    }

    @Override
    public void printCountPrompt() {
        System.out.println(COUNT_PROMPT);
    }

    @Override
    public void printResult(String result) {
        System.out.println(PLAY_RESULT + result);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
