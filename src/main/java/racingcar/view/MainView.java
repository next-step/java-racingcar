package racingcar.view;

import static racingcar.view.InputView.userInput;

public class MainView {

    public static void main(String[] args) {
        String names = userInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int times = Integer.parseInt(userInput("시도할 회수는 몇 회 인가요?"));

    }

}
