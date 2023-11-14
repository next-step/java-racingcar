package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarRacingTest {

    CarRacing carRacing = new CarRacing(new NumberGenerator() {
        @Override
        protected Integer moveCondition() {
            return 5;
        }
    });

    @Test
    void 받은_이름의_수_만큼_자동차가_생긴다() {

        carRacing.makingCar("pobi,karl");
        assertEquals(carRacing.totalCarCount(), 2);
        assertEquals(carRacing.cars().get(0).getClass(), Car.class);
    }

    @Test
    void 자동차를_받은_갯수만큼_자동차시행숫자가_생긴다() {
        carRacing.makingCar("pobi,karl,evan,david");
        assertAll(() -> {
            assertEquals(carRacing.executeNumbersCount(), 4);
            assertEquals(carRacing.executeNumbers().peek().getClass(), Integer.class);
        });
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 시행하면_차들은_움직인다(int index) {
        carRacing.makingCar("pobi,karl,evan");
        carRacing.executeRace();
        assertEquals(1, carRacing.cars().get(index).position());
    }


    @Test
    void 경주가_종료하면_우승차가_1명이상이다() {
        carRacing.makingCar("pobi,karl,evan");
        carRacing.executeRace();
        List<Car> winningCars = carRacing.getWinningRaceCars();
        assertEquals(3, winningCars.size());
    }


}
