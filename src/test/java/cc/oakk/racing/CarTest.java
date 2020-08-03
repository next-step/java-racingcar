package cc.oakk.racing;

import cc.oakk.racing.condition.CarForwardCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차가 움직이는가?")
    public void tryMoveForward_ShouldAlwaysMoveForward() {
        Car car = createMovingCar();
        
        car.tryMoveForward();
        car.tryMoveForward();
        car.tryMoveForward();
        
        assertThat(car.getMovedDistance()).isEqualTo(3);
    }
    
    @Test
    @DisplayName("자동차가 움직이지 않는가?")
    public void tryMoveForward_ShouldNotMoveForward() {
        Car car = createNotMovingCar();

        car.tryMoveForward();
        car.tryMoveForward();
        car.tryMoveForward();

        assertThat(car.getMovedDistance()).isEqualTo(0);
    }

    private Car createMovingCar() {
        CarForwardCondition<Car> mockedCondition = new CarForwardCondition<>(car -> true, car -> car);
        return new Car(mockedCondition);
    }

    private Car createNotMovingCar() {
        CarForwardCondition<Car> mockedCondition = new CarForwardCondition<>(car -> false, car -> car);
        return new Car(mockedCondition);
    }
}
