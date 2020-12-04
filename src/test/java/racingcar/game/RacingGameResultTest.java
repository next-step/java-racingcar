package racingcar.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameResultTest {

    private static final int position = 3;
    private RacingGameResult racingGameResult;
    private List<CarStatus> carStatuses;

    @BeforeEach
    void setUp() {
        racingGameResult = RacingGameResult.newInstance();
        carStatuses = Arrays.asList(CarStatus.newInstance("pobi", position),
                CarStatus.newInstance("crong", position),
                CarStatus.newInstance("honux", position)
        );
    }

    @DisplayName("한 라운드 결과 추가")
    @Test
    void addResult() {
        //when
        racingGameResult.add(RoundResult.newInstance(carStatuses));

        //then
        int expected = 1;
        List<RoundResult> roundResultList = racingGameResult.getRoundResults();
        assertEquals(expected, roundResultList.size());
    }

    @DisplayName("우승자 출력")
    @Test
    void getWinnerList() {
        //when
        racingGameResult.add(RoundResult.newInstance(carStatuses));

        //then
        assertThat(racingGameResult.getWinners()).containsExactly("pobi", "crong", "honux");
    }
}