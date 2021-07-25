package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarStadiumTest {

    private int givenLimitTime;
    private int givenCars;
    private Referee referee;
    private CarStadium carStadium;
    private ResultView resultView;
    @BeforeEach
    void setUp() {
        givenLimitTime = 10;
        givenCars = 5;

        referee = new Referee(givenLimitTime);
        carStadium = new CarStadium(referee, new ArrayList<>());
        resultView = new ResultView();
    }


    @Test
    void 자동차가_움직이면_현재_자동차의_위치를_보여준다() {
        // given
        for (int i = 0; i < givenCars; i++) {
            carStadium.enterCar(new Car(new CarEngine()));
        }

        // when then
        carStadium.moveCars();
        resultView.printResult(carStadium);

    }

    @Test
    void 자동차가_없는데_움직이면_illegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carStadium.moveCars();
            resultView.printResult(carStadium);
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

}