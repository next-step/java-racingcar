package com.hskim.nextstep.step03.racing;

import com.hskim.nextstep.step03.ui.InputView;
import com.hskim.nextstep.step03.ui.ResultView;

public class Main {

    public static void main(String[] args) {

        RacingCarSimulator carSimulator = new RacingCarSimulator();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.printPhraseToConsole("자동차 대수는 몇 대 인가요?");
        carSimulator.setRacingCarList(inputView.getIntegerFromConsoleInput());

        inputView.printPhraseToConsole("시도할 회수는 몇 회 인가요?");
        carSimulator.setGameRepeatNum(inputView.getIntegerFromConsoleInput());

        inputView.printPhraseToConsole("실행 결과");
        carSimulator.simulate(resultView);
    }
}
