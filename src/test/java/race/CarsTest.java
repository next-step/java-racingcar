package race;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {

    private static final int DEFAULT_TRY_COUNT = 5;
    private static final int DEFAULT_CAR_COUNT = 3;

    @Test
    void moveAll() {
        Cars cars = getCars();
        cars.moveAll();

        assertThat(cars.getCars().size()).isEqualTo(DEFAULT_CAR_COUNT);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void getDistanceByRound(int round) {
        Cars cars = getCars();
        cars.moveAll();
        assertThat(cars.getDistanceByRound(round).size()).isEqualTo(DEFAULT_CAR_COUNT);
    }


    Cars getCars() {
        return Cars.of(Condition.of(DEFAULT_CAR_COUNT, DEFAULT_TRY_COUNT));
    }
}