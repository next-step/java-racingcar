package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
    void 자동차가_움직이면_위치를_보여준다() {
        // given
        for (int i = 0; i < givenCars; i++) {
            carStadium.enterCar(new Car(new CarEngine()));
        }

        // when then
        carStadium.moveCars();
        carStadium.showCarsLocation();
    }

    @Test
    void 자동차가_없는데_움직이면_illegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carStadium.moveCars();
            carStadium.showCarsLocation();
        });
    }


    @Test
    void 모든_시간이_지났는데_움직이면_illegalArgumentException() {
        // given
        for (int i = 0; i < givenCars; i++) {
            carStadium.enterCar(new Car(new CarEngine()));
        }

        // when
        for (int i = 0; i < givenLimitTime; i++) {
            carStadium.moveCars();
        }

        // then
        assertThatIllegalArgumentException().isThrownBy(() ->
            carStadium.moveCars()).withMessage("더 이상 자동차는 움직일 수 없습니다.");
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