package step3.collections;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.dto.CarWentResult;

import static org.assertj.core.api.Assertions.assertThat;

class RaceResultTest {

    private List<AttemptResult> attemptResults = List.of(new AttemptResult(List.of(new CarWentResult(0,1),
                                                                                    new CarWentResult(1,0),
                                                                                    new CarWentResult(2,2))),
                                                        new AttemptResult(List.of(new CarWentResult(0,2),
                                                                                    new CarWentResult(1,1),
                                                                                    new CarWentResult(2,2))),
                                                        new AttemptResult(List.of(new CarWentResult(0,3),
                                                                                    new CarWentResult(1,2),
                                                                                    new CarWentResult(2,2))));

    @DisplayName("경주 시도 결과 중 장 앞서있는 Car의 carNumber 반환")
    @Test
    void getFistCarNumber() {
        RaceResult raceResult = new RaceResult(attemptResults);
        assertThat(raceResult.getFinalWinnerCarNumber()).isEqualTo(0);
    }

}
