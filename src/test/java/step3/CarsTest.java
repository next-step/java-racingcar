package step3;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarsTest {

    private static final int NUMBER_OF_CAR = 3;
    private static final int NUMBER_MOVE_CAR = 7;

    private Cars cars;
    private RandomGenerator randomGenerator;

    @BeforeEach
    void setUp() {
        randomGenerator = mock(RandomGenerator.class);
        when(randomGenerator.generate()).thenReturn(NUMBER_MOVE_CAR);
        cars = new Cars(getCars());
    }

    @Test
    @DisplayName("모든 자동차들을 1씩 움직이는 기능 테스트")
    public void moveCars() {
        cars.moveCars(randomGenerator);
        cars.getCars().stream().forEach(car ->
                assertEquals(car.getPosition(), 1)
        );

    }

    private List<Car> getCars() {
        List<Car> carList = new ArrayList<>();
        for (int i=0; i<NUMBER_OF_CAR; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}