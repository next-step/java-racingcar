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
        Car car = new Car(forwardCheckGenerator);

        int forwardResult = car.getForwardResult();

        assertThat(forwardResult).isEqualTo(1);
    }

    @Test
    void 자동차_진행조건인_4이상의_수가_주어지면_한칸_전진한다() {
        Car car = new Car(new FixedGo());

        car.forward();

        assertThat(car.getForwardResult()).isEqualTo(2);
    }
}
