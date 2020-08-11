package racingcar.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundResultTest {
    private final int position = 3;
    private RoundResult roundResult;

    @BeforeEach
    void setUp() {
        //given
        List<CarStatus> carStatuses = Arrays.asList(CarStatus.newInstance("pobi", position),
                CarStatus.newInstance("crong", position),
                CarStatus.newInstance("honux", position)
        );

        this.roundResult = RoundResult.newInstance(carStatuses);
    }

    @DisplayName("선두 position 구하기")
    @Test
    void winnerPosition() {
        //then
        assertEquals(position, roundResult.maxPosition());
    }

    @DisplayName("현재 라운드 우승자목록 가져오기")
    @Test
    void determineWinners() {
        //when, then
        assertThat(roundResult.determineWinners(position)).containsExactly("pobi", "crong", "honux");
    }
}
