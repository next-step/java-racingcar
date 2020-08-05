package step4.collections;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.collections.AttemptResult;
import step4.dto.CarWentResult;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AttemptResultTest {

    @DisplayName("경주 시도 결과 중 1위의 차량 이름 반환")
    @Test
    void getWinnersNames() {
        AttemptResult attemptResult = new AttemptResult(List.of(new CarWentResult("0",1),
                                                                new CarWentResult("1",0),
                                                                new CarWentResult("2",2)));
        assertThat(attemptResult.getWinnersNames()).isEqualTo("2");
    }

    @DisplayName("경주 시도 결과 중 1위가 중복이면 중복된 만큼 반환 쉼표로 붙여서 차량 이름을 반환")
    @Test
    void getOneMoreWinnersNames() {
        AttemptResult attemptResult = new AttemptResult(List.of(new CarWentResult("0",2),
                                                                new CarWentResult("1",0),
                                                                new CarWentResult("2",2),
                                                                new CarWentResult("3",2)));
        assertThat(attemptResult.getWinnersNames()).isEqualTo("0,2,3");
    }

    @DisplayName("경주 시도 결과가 없으면 IllegalStateException 던짐")
    @Test
    void throwExceptionOfGetWinnersNames() {
        AttemptResult attemptResult = new AttemptResult(Collections.EMPTY_LIST);
        assertThrows(IllegalStateException.class,()->attemptResult.getWinnersNames());
    }

}
