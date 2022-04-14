package racingcar.domain;

import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    private static final String POBI = "pobi";
    private static final String CRONG = "crong";
    private static final String HONUX = "honux";
    private static final CarName POBI_CAR_NAME = new CarName(POBI);;
    private static final CarName CRONG_CAR_NAME = new CarName(CRONG);;
    private static final CarName HONUX_CAR_NAME = new CarName(HONUX);


    @Test
    void constructor_ThrowsException_IfThereAreDuplicateNames() {
        Car pobi1 = new Car(POBI_CAR_NAME);
        Car pobi2 = new Car(POBI_CAR_NAME);

        assertThatThrownBy(() -> new Cars(List.of(pobi1, pobi2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getNameToPosition() {
        Car pobi = new Car(POBI_CAR_NAME, new Position());
        Car crong = new Car(CRONG_CAR_NAME, new Position(1));
        Car honux = new Car(HONUX_CAR_NAME, new Position(2));
        Cars cars = new Cars(List.of(pobi, crong, honux));

        assertThat(cars.getNameToPosition())
                .contains(MapEntry.entry(POBI, 0), MapEntry.entry(CRONG, 1), MapEntry.entry(HONUX, 2));
    }

    @Test
    void getMostDistantCarNames() {
        Car pobi = new Car(POBI_CAR_NAME, new Position());
        Car crong = new Car(CRONG_CAR_NAME, new Position(5));
        Car honux = new Car(HONUX_CAR_NAME, new Position(5));
        Cars cars = new Cars(List.of(pobi, crong, honux));

        assertThat(cars.getMostDistantCarNames())
                .containsExactly(CRONG, HONUX);
    }
}