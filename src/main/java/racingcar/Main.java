package racingcar;

import static racingcar.view.InputView.inputNum;

public class Main {

    public static void main(String[] args) {
        int carNum = inputNum("자동차 대수는 몇 대 인가요?");
        int times = inputNum("시도할 회수는 몇 회 인가요?");
        new Racing(carNum, times).start();
    }

}
