package racing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.RandomStadiumMoveOptionImpl;
import racing.domain.Stadium;

import java.util.ArrayList;
import java.util.List;


public class StadiumTest {

    @DisplayName("자동차들 중에서 가장 멀리 간 위치가 어디인지 알 수 있다.")
    @Test
    void getMaxCarPosition() {

        List<Car> cars = new ArrayList<>();

        int maxPosition = 5;

        cars.add(new Car("lucas", maxPosition));
        cars.add(new Car("kai"));

        Stadium stadium = new Stadium(cars, 2, () -> { return 1;});


        Assertions.assertEquals(stadium.getMaxCarPosition(), maxPosition);
    }


}
