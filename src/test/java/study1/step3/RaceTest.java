package study1.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RaceTest {
    private int carCnt;
    private int raceCnt;

    @BeforeEach
    void setUp(){
        this.carCnt = 1;
        this.raceCnt = 3;
    }

    @ParameterizedTest
    @DisplayName("Move Decision Test")
    @CsvSource(value = {"3:1", "6:4"}, delimiter = ':')
    void moveDecisionTest(String decisionNumber, int result){
        Cars cars = Cars.of(this.carCnt);
        Decision fixedDecision = new FixedMoveDecision(Integer.parseInt(decisionNumber));
        for(int i = 0; i < raceCnt; i++) {
            cars.race(fixedDecision);
        }
        assertThat(cars.getCars().get(0).getMoveDistance()).isEqualTo(result);
    }

    @Test
    @DisplayName("Setting Validate Test")
    void validateTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.validateNumber(-1);
        });
    }
}
