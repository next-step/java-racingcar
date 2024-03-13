package racing_winner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racing.RandomFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

public class CarRacingTest {


    @Test
    @DisplayName("game이 정상적으로 동작을한다.")
    void gameSuccess(){
        List<String> carNames = List.of("Car1","Car2");
        int racingCount = 3;
        RandomFactory randomFactory = mock(RandomFactory.class);
        CarRacingPrinter carRacingPrinter = mock(CarRacingPrinter.class);
        CarRacing carRacing = new CarRacing(carNames, racingCount, randomFactory, carRacingPrinter);
        when(randomFactory.getNextInt()).thenReturn(4);

        carRacing.game();

        verify(carRacingPrinter).printWinners(anyList());
    }

    @Test
    @DisplayName("car리스트에서  max_value를 찾는다")
    void findMaxMultipleFromStream() {
        Car car1 = new Car("steve");
        Car car2 = new Car("elvis");
        Car car3 = new Car("colin");

        car1.tryMove(3);
        car1.tryMove(3);
        car2.tryMove(2);

        List<Car> cars = List.of(car1, car2, car3);

        int max = cars.stream().mapToInt(Car::getLevel).max().orElse(0);
        Assertions.assertThat(max).isEqualTo(2);
    }

    @Test
    @DisplayName("car 리스트에서 특정 level을 가진 car들을 찾는다.")
    void findCarsByLevel() {
        Car car1 = new Car("steve");
        Car car2 = new Car("elvis");
        Car car3 = new Car("colin");

        car1.tryMove(3);
        car1.tryMove(3);
        car2.tryMove(2);
        car2.tryMove(2);

        List<Car> cars = List.of(car1, car2, car3);

        int max = 2;

        List<Car> winner = cars.stream().filter(car -> car.getLevel() == max).collect(Collectors.toList());

        Assertions.assertThat(winner.size()).isEqualTo(2);
    }
}
