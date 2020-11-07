package study1.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @DisplayName("Car Test")
    void carTest(){
        // 무조건 전진
        Decision fixedDecision = new FixedMoveDecision(10);

        Car car = new Car(1);
        car.move(fixedDecision);
        car.move(fixedDecision);
        car.move(fixedDecision);
        car.move(fixedDecision);
        assertThat(car.getMoveDistance()).isEqualTo(5);

        // 전진 못 하는 자동차
        fixedDecision = new FixedMoveDecision(1);

        car = new Car(1);
        car.move(fixedDecision);
        car.move(fixedDecision);
        car.move(fixedDecision);
        car.move(fixedDecision);
        assertThat(car.getMoveDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("Race Board Test")
    void raceBoardTest(){
        int testNumber = 5;

        Car car = new Car(testNumber);
        RaceBoard raceBoard = new RaceBoard();
        assertThat(raceBoard.getMoveDistance(car).length()).isEqualTo(testNumber);
    }

    @Test
    @DisplayName("Race Test")
    void totalTest(){
        Race testRace = Race.of(5, 3);
        testRace.race();
    }
}
