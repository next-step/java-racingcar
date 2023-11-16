package racingCar.ui;

import racingCar.game.RacingGameRequest;

public interface InputView { // 사용자 입력이 무엇인지 알고, 다룰 수 있다.
	RacingGameRequest gameRequestWithNames();
}
