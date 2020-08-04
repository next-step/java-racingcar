package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import racingcar.model.RacingRecord;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RacingGameTest {

    private RacingGameStub racingGameStub;

    @BeforeAll
    void setUp() {
        int racingCarNumber = 3;
        int racingCount = 5;
        racingGameStub = new RacingGameStub(racingCarNumber, racingCount);
    }

    @Test
    @DisplayName("자동차 경주 게임 동작 테스트")
    void startTest() {
        // given
        String expectedMark1 = "-\n-\n-";
        String expectedMark2 = "--\n--\n--";
        String expectedMark3 = "---\n---\n---";
        String expectedMark4 = "----\n----\n----";
        String expectedMark5 = "-----\n-----\n-----";

        // when
        RacingRecord racingRecord = racingGameStub.start();

        // then
        assertAll(
                () -> assertThat(racingRecord.getAllRecord()).hasSize(5),
                () -> assertThat(racingRecord.getAllRecord()).contains(expectedMark1),
                () -> assertThat(racingRecord.getAllRecord()).contains(expectedMark2),
                () -> assertThat(racingRecord.getAllRecord()).contains(expectedMark3),
                () -> assertThat(racingRecord.getAllRecord()).contains(expectedMark4),
                () -> assertThat(racingRecord.getAllRecord()).contains(expectedMark5)
        );
    }
}
