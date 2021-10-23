package racingcar;

import racingcar.views.InputView;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.getRacingInformation();

        Map<String, String> answerMap = inputView.getAnswerMap();

    }
}
