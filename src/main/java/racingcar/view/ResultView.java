package racingcar.view;

import racingcar.Constants;

public class ResultView {
    public void printResult(int currentPosition) {
        String result = "";
        for (int i = 0; i < currentPosition; i++) {
            result += Constants.MOVE_MARK;
        }
        System.out.println(result);
    }
}
