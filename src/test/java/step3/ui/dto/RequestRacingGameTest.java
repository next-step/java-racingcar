package step3.ui.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 사용자 요청 값 테스트
 */
class RequestRacingGameTest {

    @DisplayName("사용자의 입력 값을 관리할 객체 테스트")
    @ParameterizedTest(name = "carCount: {0}, tryCount:{1} 입력 테스트")
    @CsvSource(value = {"1, 2", "2, 4"})
    void userRequest_ShouldExistCarCountNTryCount(int carCount, int tryCount) {

        RequestRacingGame request = new RequestRacingGame(carCount, tryCount);

        int carCnt = request.getParticipants();
        int tryCnt = request.getAttemptCount();

        assertThat(carCount).isEqualTo(carCnt);
        assertThat(tryCount).isEqualTo(tryCnt);
    }
}
