package study1.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRace {
    private int carCnt;
    private int raceCnt;
    private Decision moveDecision;

    @BeforeEach
    void setUp(){
        this.carCnt = 1;
        this.raceCnt = 3;
    }

    @ParameterizedTest
    @CsvSource(value = {"3:1", "6:4"}, delimiter = ':')
    void moveDecisionTest(String decisionNumber, int result){
        Cars cars = Cars.of(this.carCnt);
        Decision fixedDecision = new FixedMoveDecision(Integer.parseInt(decisionNumber));
        for(int i = 0; i < raceCnt; i++) {
            cars.race(fixedDecision);
        }
        assertThat(cars.getCarList().get(0).getMoveDistance()).isEqualTo(result);
    }
}
