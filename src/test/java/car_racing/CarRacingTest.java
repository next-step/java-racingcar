package car_racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.TestNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CarRacingTest {

    @BeforeEach
    void tear() {
        clearAllCaches();
    }

    @Test
    @DisplayName("car 사이즈에 따라 car가 생성되어야 한다.")
    void initCars() {
        // when
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(0);
        CarRacing carRacing = new CarRacing(Car.generateCars(3, testNumberGenerator));

        // then
        assertThat(carRacing.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("cars 사이즈에 따라 car를 움직여야한다.")
    void moveCars() {
        // given
        List<Car> carMocks = Arrays.asList(mock(Car.class), mock(Car.class), mock(Car.class));
        CarRacing carRacing = new CarRacing(carMocks);
        carRacing.setCars(carMocks);

        // when
        carRacing.moveCars();

        // then
        verify(carMocks.get(0), times(1)).moveOrStop();
        verify(carMocks.get(1), times(1)).moveOrStop();
        verify(carMocks.get(2), times(1)).moveOrStop();
        verifyNoMoreInteractions(carMocks.toArray());
    }

}
