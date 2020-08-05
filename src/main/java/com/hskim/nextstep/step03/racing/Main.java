package com.hskim.nextstep.step03.racing;

import com.hskim.nextstep.step03.ui.InputView;
import com.hskim.nextstep.step03.ui.ResultView;

public class Main {

    public static void main(String[] args) {

        RacingCarSimulator carSimulator = new RacingCarSimulator();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.printPhraseToConsole("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carSimulator.setRacingCarList(inputView.getStringFromConsoleInput());

        inputView.printPhraseToConsole("시도할 회수는 몇 회 인가요?");
        carSimulator.setGameRepeatNum(inputView.getIntegerFromConsoleInput());

        resultView.printPhraseToConsole("실행 결과");
        carSimulator.simulate(resultView);
    }
}
