package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.game.domain.Cars;
import step2.game.domain.RacingGameRecord;

import static org.assertj.core.api.Assertions.*;

public class RacingGameRecordTest {
    private RacingGameRecord racingGameRecord;

    @BeforeEach
    void before() {
        this.racingGameRecord = RacingGameRecord.newGame(Cars.newCars(3));
    }

    @Test
    @DisplayName("직전 턴 기록 조회시 turnNo 가 0보다 작은 경우")
    void invalid_turn_no() {
        assertThatIllegalArgumentException().isThrownBy(() -> racingGameRecord.previousTurn(-1));
    }

    @Test
    @DisplayName("직전 턴 기록 조회시 turnNo 가 현재 record 인덱스 범위를 벗어난 경우")
    void invalid_over_turn_no() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(
            () -> racingGameRecord.previousTurn(5)
        );
    }

    @Test
    @DisplayName("직전 턴 기록 조회하기")
    void before_record() {
        Cars previousTurn = racingGameRecord.previousTurn(0);
        assertThat(previousTurn.getCars().size()).isEqualTo(3);
        assertThat(previousTurn.getCars().get(0).getPosition()).isEqualTo(0);
        assertThat(previousTurn.getCars().get(1).getPosition()).isEqualTo(0);
        assertThat(previousTurn.getCars().get(2).getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("현재 경주 기록을 새롭게 저장한 Record 리턴")
    void new_record() {
        Cars previousTurn = racingGameRecord.previousTurn(0);
        Cars turnResult = previousTurn.startTurn();
        racingGameRecord.record(turnResult);
        assertThat(racingGameRecord.getResult().size()).isEqualTo(2);
    }

}
