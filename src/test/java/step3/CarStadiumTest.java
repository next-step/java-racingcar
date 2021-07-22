package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class CarStadiumTest {

    private int givenLimitTime;
    private int givenCars;
    private Referee referee;
    private CarStadium carStadium;

    @BeforeEach
    void setUp() {
        givenLimitTime = 10;
        givenCars = 5;

        referee = new Referee(givenLimitTime);
        carStadium = new CarStadium(referee, new ArrayList<>());
    }

    @Test
    void 스타디움의_입장한_자동차_수와_총_몇번_움직일_수_있는지_알_수_있어야한다() {
        // given
        for (int i = 0; i < givenCars; i++) {
            carStadium.enterCar(new Car(new CarEngine()));
        }

        // when
        int actualLimitTime = referee.getLimitTime();
        int actualCarsCount = carStadium.carsCount();

        // then
        assertThat(actualLimitTime).isEqualTo(givenLimitTime);
        assertThat(actualCarsCount).isEqualTo(givenCars);
    }


}