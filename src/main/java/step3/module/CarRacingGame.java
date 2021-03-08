package step3.module;

import step3.domain.CarManage;
import step3.domain.RacingRound;
import step3.ui.dto.RequestRacingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static step3.util.Constants.START_IDX;

/**
 * 레이싱 게임 역할을 하는 클래스
 */
public class CarRacingGame {

    // 자동차 게임이 실행되기 위한 필수 필드
    private final CarManage carManage;
    private final int attemptCount;
    private final List<RacingRound> racingRounds = new ArrayList<>();

    public CarRacingGame(RequestRacingGame userInput) {
        attemptCount = userInput.getAttemptCount();
        carManage = new CarManage(userInput.getParticipants());
    }

    // 레이스
    public void race() {
        IntStream.range(START_IDX, attemptCount)
                .forEach(value ->
                        // 라운드 별 기록 저장
                        racingRounds.add(carManage.run()));
    }

    public List<RacingRound> getRacingResult() {
        return racingRounds;
    }
}
