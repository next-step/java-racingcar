package step3.game.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameRecordTest {
    private RacingGameRecord racingGameRecord;

    @BeforeEach
    void before() {
        List<CarName> carNames = new ArrayList<>();
        carNames.add(new CarName("pobi"));
        carNames.add(new CarName("crong"));
        carNames.add(new CarName("honux"));
        this.racingGameRecord = RacingGameRecord.newGame(Cars.newCars(carNames));
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

    @Test
    @DisplayName("우승자는 한 명 이상")
    void winners_count() {
        assertThat(racingGameRecord.winners().size() > 0).isTrue();
    }

    @Test
    @DisplayName("게임 기록이 없는 상태에서 우승자 조회")
    void no_record_game() {
        RacingGameRecord record = new RacingGameRecord(new ArrayList<>());
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(record::winners);
    }

}
