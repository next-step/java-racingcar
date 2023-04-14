package racingcar;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CollectionsTest {

    @Test
    void 불변리스트반환() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car());

        List<Car> unmodifiable = Collections.unmodifiableList(carList);

        assertAll(
            () -> assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(() -> unmodifiable.add(new Car())),
            () -> assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(() -> unmodifiable.remove(0))
        );

        unmodifiable.get(0).move(); //
    }

}
