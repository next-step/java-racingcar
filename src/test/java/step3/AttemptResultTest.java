package step3;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.dto.CarWentResult;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AttemptResultTest {

    @DisplayName("경주 시도 결과 중 장 앞서있는 Car의 carNumber 반환")
    @Test
    void getFistCarNumber() {
        AttemptResult attemptResult = new AttemptResult(List.of(new CarWentResult(1,1),
                                                                new CarWentResult(0,2),
                                                                new CarWentResult(2,3)));
        assertThat(attemptResult.getFistCarNumber()).isEqualTo(3);
    }

    @DisplayName("경주 시도 결과가 없으면 IllegalStateException 던짐")
    @Test
    void throwExceptionOfGetFistCarNumber() {
        AttemptResult attemptResult = new AttemptResult(Collections.EMPTY_LIST);
        assertThrows(IllegalStateException.class,()->attemptResult.getFistCarNumber());
    }

}