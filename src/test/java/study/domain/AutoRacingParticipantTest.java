package study.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoRacingParticipantTest {

    @Test
    @DisplayName("참가자중, 이동횟수가 가장큰 모든 참가자의 이름을 list로 리턴하는 테스트 ")
    void getAllMaxMoveCountName() {
        //given
        List<RacingCar> racingCarList = new ArrayList<>() {{
            add(new RacingCar("최태훈1", 4));
            add(new RacingCar("최태훈2", 4));
            add(new RacingCar("최태훈3"));
        }};

        AutoRacingParticipant autoRacingParticipant = new AutoRacingParticipant();
        autoRacingParticipant.participateGame(racingCarList);

        List<String> maxMoveCountNameList = autoRacingParticipant.getAllMaxMoveCountName();
        assertThat(maxMoveCountNameList.size()).isEqualTo(2);
        assertThat(maxMoveCountNameList).contains("최태훈1", "최태훈2");

    }
}