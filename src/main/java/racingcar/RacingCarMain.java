package racingcar;


import static racingcar.racing.Racing.racingStart;
import static racingcar.view.InputView.getSystemInInt;
import static racingcar.view.InputView.getSystemInString;

public class RacingCarMain {
    public static void main(String[] args) {
        String carsName = getSystemInString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int tryCount = getSystemInInt("시도할 회수는 몇 회 인가요?");

        racingStart(carsName, tryCount);
    }
}
