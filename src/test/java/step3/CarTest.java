package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Car;
import step3.strategy.MovementStrategy;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Step3 - 자동차 Object에 대한 Test")
public class CarTest {
    private Car challenger;

    @Test
    @DisplayName("Car Construction 정상 작동여부확인")
    void new_Car_object_creation() {
        challenger = new Car();
        assertThat(challenger.showDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("Car 객체에 정의된 Method로 자동차가 이동했는지 확인")
    void increse_Car_Distance_with_Method() {
        challenger = new Car();
        challenger.increaseDistance();
        assertThat(challenger.showDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName("Car 객체에 정의된 수행전략에 의해 자동차가 움직이는지 확인 - 임시 true 전략 준 뒤 값이 증가하는지 Test")
    void increate_Car_Distance_with_Randomize() {

        MovementStrategy tmpStrategy = new MovementStrategy() {
            @Override
            public boolean movementAction() {
                return true;
            }
        };
        challenger = new Car(1, tmpStrategy);
        challenger.accelerateCar();
        assertThat(challenger.showDistance()).isGreaterThan(1);
    }
}
