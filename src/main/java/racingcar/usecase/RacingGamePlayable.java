package racingcar.usecase;

import racingcar.usecase.request.RacingGamePlayRequest;
import racingcar.usecase.response.RacingGamePlayResponse;

/**
 * RacingGame을 실행하는 역할을 하는 인터페이스 입니다.
 */
public interface RacingGamePlayable {

    /**
     * round정보와, RacingGamePlayRequest를 받아서, 게임을 진행하고, 게임의 결과를 반환한다.
     *
     * @param round                 진행할 게임의 판수
     * @param racingGamePlayRequest 레이싱 게임에 사용할 car의 정보
     * @return RacingGamePlayResponse 레이싱 게임의 결과
     */
    RacingGamePlayResponse play(int round, RacingGamePlayRequest racingGamePlayRequest);

}
