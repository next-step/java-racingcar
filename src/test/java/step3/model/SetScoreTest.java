package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Score 기록에 따라 출력하기 위한 객체 생성 및 메소드 테스트")
class SetScoreTest {
    public SetScore setScore;

    @ParameterizedTest
    @CsvSource(value = {"1,0", "2,1"})
    @DisplayName("Constructor 및 getScoreOfCar 체크")
    public void create_SetScore_With_Parameters(int size, int numberOfParticipant) {
        setScore = new SetScore(size);
        assertThat(setScore.getScoreOfCar(numberOfParticipant)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0,3,3"})
    @DisplayName("Score에 실제 점수 기록 후, 반영되었는지 확인")
    public void create_SetScore_and_setMethod(int size, int numberOfParticipant, int score, int expected) {
        setScore = new SetScore(size);
        setScore.setScoreOfCar(numberOfParticipant, score);
        assertThat(setScore.getScoreOfCar(numberOfParticipant)).isEqualTo(expected);
    }
}