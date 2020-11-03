package study1.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @CsvSource(value = {"3:-", "6:----"}, delimiter = ':')
    void moveDecisionTest(String decisionNumber, String result){
        CarList carList = new CarList(this.carCnt,
                new FixedMoveDecision(Integer.parseInt(decisionNumber)));
        for(int i = 0; i < raceCnt; i++) {
            carList.race();
        }
        assertThat(carList.getCarList().get(0).getMoveDistance()).isEqualTo(result);
    }
}
