package racingcar.controller;

import racingcar.model.StringParser;
import racingcar.view.InputView;

public class RacingGameRunner {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = InputView.enter();
        String[] names = StringParser.split(input);
        System.out.println("시도할 회수는 몇회인가요?");
        int numbers = InputView.enterNumber();
    }
}
