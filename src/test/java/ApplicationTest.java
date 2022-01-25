import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.util.RandomGenerator;

public class ApplicationTest {
    @Test

    void 전진_불가 (){
        Car car = new Car("Jiin");
        car.moveForward(1);
        assertThat(car.getPosition()).isEqualTo("");
    }

    void 전진_가능(){
        Car car = new Car("Leah");
        car.moveForward(5);
        assertThat(car.getPosition()).isEqualTo("-");
    }

    void 이름_5글자_이상(){
        assertThatIllegalArgumentException()
            .isThrownBy(()-> new Car("LeahJiin"));
    }



}
