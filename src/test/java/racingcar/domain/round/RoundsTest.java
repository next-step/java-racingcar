package racingcar.domain.round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("자동차 경주 - Rounds 테스트")
class RoundsTest {
    private final List<Round> mockRoundList = new ArrayList<>();
    private Rounds rounds;

    @BeforeEach
    public void init() {
        for (int i = 0; i < 5; i++) {
            mockRoundList.add(mock(Round.class));
        }
        rounds = new Rounds(mockRoundList);
    }


    @Test
    void play는_라운드_전체를_play한다() {
        rounds.play();

        mockRoundList.forEach(round -> verify(round).play());
    }
}
