package study.step3;

import study.step3.util.KeyboardInput;

public class InputView {

    public String[] readCarName() {
        return KeyboardInput.readInputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).").split(",");
    }

    public int readGameRound() {
        return KeyboardInput.readInputNum("시도할 횟수는 몇 회 인가요?");
    }

}
