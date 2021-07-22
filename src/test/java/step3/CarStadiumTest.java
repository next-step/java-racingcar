package step3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class CarStadiumTest {

    @Test
    void 스타디움의_입장한_자동차_수와_총_몇번_움직일_수_있는지_알_수_있어야한다() {
        // given
        int givenLimitTime = 10;
        int givenCars = 5;

        CarStadium carStadium = new CarStadium(givenLimitTime, new ArrayList<>());

        for (int i = 0; i < givenCars; i++) {
            carStadium.enterCar(new Car());
        }

        // when
        int actualLimitTime = carStadium.getLimitTime();
        int actualCarsCount = carStadium.carsCount();

        // then
        assertThat(actualLimitTime).isEqualTo(givenLimitTime);
        assertThat(actualCarsCount).isEqualTo(givenCars);
    }


}