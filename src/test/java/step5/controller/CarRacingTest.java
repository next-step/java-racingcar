package step5.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.controller.CarRacing;
import step5.model.Cars;
import step5.utility.ReturnRandomValue;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    @Test
    @DisplayName("난수 생성 테스트")
    public void createRandom() {
        final int BIG_NUMBER = 10000;

        for (int i = 0; i < BIG_NUMBER; i++) {
            assertThat(ReturnRandomValue.returnValue()).isBetween(0, 9);
        }
    }

    @Test
    public void returnCarsObj(){
        String carNames[] = {"hbl","zorba"};
        Cars cars = CarRacing.returnCarsObj(carNames);

        assertThat(cars.getCars()).hasSize(2);
    }
}
