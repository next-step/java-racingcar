import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class RacingGameTest {

    RacingGame racingGame = new RacingGame();

    @Test
    public void 자동차_리스트_생성(){
        String[] carNames = {"sunny","test","myCar"};
        List<Car> cars = racingGame.makeCars(carNames);
        assertThat(cars.size()).isEqualTo(carNames.length);

        IntStream.range(0, cars.size()).forEach(idx -> {
            assertThat(cars.get(idx).getDistance()).isEqualTo(0);
            assertThat(cars.get(idx).getName()).isEqualTo(carNames[idx]);
        });
    }

    @Test
    public void 자동차_경주_우승자_확인_단독(){
        List<Car> cars = Arrays.asList(new Car("sunny"),new Car("kookoo"),new Car("rin"));
        cars.get(0).move();
        cars.get(0).move();
        List<Car> winnerCars = racingGame.getWinners(cars);

        int max = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();

        winnerCars.stream().filter(car -> car.getDistance()==max).collect(Collectors.toList());

        assertThat(winnerCars.size()).isEqualTo(1);
        assertThat(winnerCars.get(0).getName()).isEqualTo("sunny");

    }


    @Test
    public void 자동차_경주_우승자_확인_공동우승(){
        List<Car> cars = Arrays.asList(new Car("sunny"),new Car("kookoo"),new Car("rin"));
        cars.get(0).move();
        cars.get(1).move();
        List<Car> winnerCars = racingGame.getWinners(cars);

        int max = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();

        winnerCars.stream().filter(car -> car.getDistance()==max).collect(Collectors.toList());

        assertThat(winnerCars.size()).isEqualTo(2);
        assertThat(winnerCars.get(0).getName()).isEqualTo("sunny");
        assertThat(winnerCars.get(1).getName()).isEqualTo("kookoo");

    }

}
