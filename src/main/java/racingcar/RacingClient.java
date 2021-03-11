package racingcar;

import racingcar.view.InputView;

import java.util.Arrays;

public class RacingClient {
    public static void main(String[] args) {
        InputView inputView = new InputView(Arrays.asList("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", "시도할 회수는 몇회인가요?"));
        Racing racing = new Racing(inputView);
        racing.start();
    }
}
