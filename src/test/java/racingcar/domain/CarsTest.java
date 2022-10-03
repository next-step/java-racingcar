package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @DisplayName("자동차들이 이동하면 이동거리 목록을 리턴한다.")
    @Test
    void move() {
        List<String> carNames = List.of("pobby", "luna");
        
        Distances expected = distances(carNames);

        assertThat(equalsByName(cars(carNames).move(), expected)).isTrue();
    }

    private boolean equalsByName(Distances actual, Distances expected) {
        return actual.names().equals(expected.names());
    }
    
    private Distances distances(List<String> carNames) {
        List<Distance> distances = new ArrayList<>();
        for (String carName : carNames) {
            distances.add(new Distance(carName));
        }
        return new Distances(distances);
    }

    private Cars cars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }
}
