package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AutoRacingParticipantTest {

    @Test
    @DisplayName("참가자중, 이동횟수가 가장큰 모든 참가자의 이름을 list로 리턴하는 테스트 ")
    void getAllMaxMoveCountName() {
        //given
        RacingCar racingCar1 = new RacingCar("최태훈1");
        racingCar1.moveOrStop(7);
        racingCar1.moveOrStop(7);
        racingCar1.moveOrStop(7);
        racingCar1.moveOrStop(7);
        //racingCar ---- > name : 최태훈1 , moveCount: 4
        RacingCar racingCar2 = new RacingCar("최태훈2");
        racingCar2.moveOrStop(7);
        racingCar2.moveOrStop(7);
        racingCar2.moveOrStop(7);
        racingCar2.moveOrStop(7);
        //racingCar ---- > name : 최태훈2 , moveCount: 4

        RacingCar racingCar3 = new RacingCar("최태훈3");
        racingCar3.moveOrStop(3);
        racingCar3.moveOrStop(3);
        racingCar3.moveOrStop(3);
        racingCar3.moveOrStop(3);
        //racingCar ---- > name : 최태훈3 , moveCount: 0

        List<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(racingCar1);
        racingCarList.add(racingCar2);
        racingCarList.add(racingCar3);

        AutoRacingParticipant autoRacingParticipant = new AutoRacingParticipant();
        autoRacingParticipant.participateGame(racingCarList);

        List<String> maxMoveCountNameList = autoRacingParticipant.getAllMaxMoveCountName();
        assertThat(maxMoveCountNameList.size()).isEqualTo(2);
        assertThat(maxMoveCountNameList.get(0)).isEqualTo("최태훈1");
        assertThat(maxMoveCountNameList.get(1)).isEqualTo("최태훈2");

    }
}