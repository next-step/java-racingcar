package racingcar.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.ProceedStrategy;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MementoTest {

    @Test
    @DisplayName("addCar 를 하면 자동차가 추가되어야 한다.")
    void addCar() {
        String name = "dumb";
        MoveStrategy strategy = ProceedStrategy.getInstance();
        Car car = Car.createCar(name, strategy);

        Memento memento = new Memento();
        memento.addCar(car);
        List<Car> cars = memento.getCars();
        Iterator<Car> itr = cars.iterator();
        Car addedCar = itr.next();

        Assertions.assertAll(
                () -> {
                    assertThat(addedCar.getName())
                            .isEqualTo(car.getName());
                },
                () -> {
                    assertThat(addedCar.getPosition())
                            .isEqualTo(car.getPosition());
                },
                () -> {
                    assertThat(itr.hasNext())
                            .isFalse();
                }
        );

    }
}
