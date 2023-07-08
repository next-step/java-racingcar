package racingcar;

import java.util.List;
import java.util.Scanner;

public class View {

    private final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private final String COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final String PLAY_RESULT_TITLE_MESSAGE = "\n실행 결과";

    private String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void prints(List<String> messages) {
        for (String message : messages) {
            print(message);
        }
    }

    private void printCarNames() {
        print(CAR_NAMES_MESSAGE);
    }

    private void printCount() {
        print(COUNT_MESSAGE);
    }

    private void printPlayResultTitle() {
        print(PLAY_RESULT_TITLE_MESSAGE);
    }

    public String readCarNames() {
        printCarNames();
        return read();
    }

    public String readCount() {
        printCount();
        return read();
    }

    public void printResult(List<String> racingGameResult) {
        printPlayResultTitle();
        prints(racingGameResult);
    }

}
