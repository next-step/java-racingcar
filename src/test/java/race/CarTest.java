package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private ForwardCheck forwardCheckGenerator;


    @BeforeEach
    void initRandomNumber() {
        forwardCheckGenerator = new CarForwardCheck();
    }

    @Test
    void 자동차를_생성하면_전진하는_방향이_하나_생성된다() {
        String carName = "tCar";
        Car car = new Car(carName, forwardCheckGenerator);

        int forwardResult = car.getForwardResult();

        assertThat(forwardResult).isEqualTo(1);
    }

    @Test
    void 자동차_진행조건인_4이상의_수가_주어지면_한칸_전진한다() {
        String carName = "tCar";
        Car car = new Car(carName, new FixedGo());

        car.forward();

        assertThat(car.getForwardResult()).isEqualTo(2);
    }

    @Test
    void 자동차_이름이_5글자를_초과하면_예외가_발생한다() {
        String carName = "testCar";
        assertThatThrownBy(() -> new Car(carName, new FixedGo()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("CarName is too long");
    }

    @Test
    void 자동차_위치가_가장_멀리간_위치인지_확인한다() {
        Car car = new Car("testC", 4, new FixedGo());

        assertThat(car.isMaxPosition(4)).isTrue();
    }

    @Test
    void 자동차_위치와_현재_가장_멀리간_위치중에서_더_큰값을_반환한다() {
        Car car = new Car("testC", 4, new FixedGo());
        int maxPosition = 5;

        assertThat(car.compareWithMaxPosition(maxPosition)).isEqualTo(5);
    }
}
