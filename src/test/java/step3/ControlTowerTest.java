package step3;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.collections.AttemptResult;
import step3.collections.RaceResult;
import step3.dto.CarWentResult;
import step3.dto.ParticipationForm;

import static org.assertj.core.api.Assertions.assertThat;

class ControlTowerTest {

    private static final ParticipationForm MOCK_PARTICIPATION_FORM = new ParticipationForm(3,2);

    private ControlTower controlTower = new ControlTower(MOCK_PARTICIPATION_FORM);

    @DisplayName("레이싱 결과 리스트의 크기가 ParticipationForm의 attemptCount와 같은지 확인")
    @Test
    void startCarRacing() {
        RaceResult assertRaceResult = new RaceResult(List.of(
                new AttemptResult(List.of(
                        new CarWentResult(0,0),
                        new CarWentResult(1,0),
                        new CarWentResult(2,0)
                )),
                new AttemptResult(List.of(
                        new CarWentResult(0,0),
                        new CarWentResult(1,0),
                        new CarWentResult(2,0)
                ))
        ));
        assertThat(controlTower.startCarRacing()).isEqualTo(assertRaceResult);
    }

}