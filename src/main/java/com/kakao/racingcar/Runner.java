package com.kakao.racingcar;

import com.kakao.racingcar.domain.car.RacingGame;
import com.kakao.racingcar.domain.user.UserNameInfo;
import com.kakao.racingcar.ui.InputView;
import com.kakao.racingcar.ui.OutputView;

import java.util.List;

public class Runner {
    public static void main(String args[]) {
        InputView inputView = new InputView(System.in);
        List<String> userNames = UserNameInfo.parse(inputView.inputUserNames());
        int tryCount = inputView.inputTryCount();
        RacingGame racingGame = new RacingGame(tryCount, userNames);
        racingGame.runRace();
        OutputView.printRacingGame(racingGame.getRacingHistory());
    }
}
