package step4.dto.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.dto.RandomStrategy;
import step4.dto.RunStrategy;
import step4.dto.count.Count;

import java.util.ArrayList;
import java.util.List;

class CarGroupTest {

    @ParameterizedTest
    @CsvSource(value = {"4,5,6|a"})
    @DisplayName("")
    public void findWinner() {
        RunStrategy runStrategy = new RandomStrategy();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(runStrategy, "poby"));
        cars.add(new Car(runStrategy, "dy"));
        cars.add(new Car(runStrategy, "reviewer"));

        cars.get(0).run(new Count(4));
        cars.get(0).run(new Count(5));
        cars.get(0).run(new Count(6));
    }
}
