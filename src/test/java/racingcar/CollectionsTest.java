package racingcar;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CollectionsTest {

    @Test
    void 불변리스트반환() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car());

        List<Car> unmodifiable = Collections.unmodifiableList(carList);
        assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(() -> unmodifiable.add(new Car()));

        unmodifiable.get(0).move(); //
    }

}
