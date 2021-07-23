package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new Car();
    }

    @Test
    @DisplayName("Car의 위치(location)이 증가하는지 테스트")
    void progressTest() {
        IntStream.range(0, 10)
                .forEach((i) -> {
                    int before = car.getLocation();

                    car.progress();

                    int after = car.getLocation();

                    assertThat(after).isEqualTo(before + 1);
                });
    }
}
