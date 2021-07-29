package step5;

import helper.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.enums.MOVE;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new Car("Car");
    }

    @Test
    @DisplayName("Car이 진행하거나 진행하지 않는 케이스가 나오는지 테스트")
    void goOrStopTest() {
        Set<MOVE> moveResult = new HashSet<>();

        IntStream.range(0, 100)
                .forEach((i) -> {
                    int before = car.getCarLocation().getValue();

                    car.goOrStop(() -> true);

                    int after = car.getCarLocation().getValue();

                    if (before == after) {
                        moveResult.add(MOVE.STOP);
                    }

                    if (before < after) {
                        moveResult.add(MOVE.GO);
                    }
                });

        assertThat(moveResult.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Car의 위치(location)이 증가하는지 테스트")
    void progressTest() {
        try {
            int before = car.getCarLocation().getValue();

            TestHelper.invokePrivateMethod(car, "progress");

            int after = car.getCarLocation().getValue();

            assertThat(after).isEqualTo(before + 1);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
