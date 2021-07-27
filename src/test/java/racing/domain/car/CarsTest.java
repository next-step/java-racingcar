package racing.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.car.BasicCar;
import racing.domain.car.Car;
import racing.domain.car.Cars;
import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.BasicFuel;
import racing.domain.fuel.Fuel;
import racing.domain.turn.Turn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarsTest {
    /*
    요구 사항은 ','를 기준으로 이름을 입력 받지만
    * @CsvSource의 기본 구분 문자가 ',' 이기 때문에
    * 테스트 에서는 이름 구분자를 '|' 로 변경
    */
    private static final String NAME_DELIMITER = "\\|";
    public Cars initCars(String strNames, Function<Name, Car> carCtor) {
        String[] strNameSplitValues = strNames.split(NAME_DELIMITER);

        return new Cars(
                Arrays.stream(strNameSplitValues)
                        .map(Name::new)
                        .map(carCtor)
                        .collect(Collectors.toSet())
        );
    }

    private String newAnonymousName(int identity) {
        return String.valueOf(identity);
    }

    private String sizeToNames(int size) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(
                    newAnonymousName(i)).append("|");
        }
        if (builder.length() > 0)
            return builder.substring(0, builder.length() - 1);
        return builder.toString();
    }

    @ValueSource(ints = {
            10, 100, 1000
    })
    @DisplayName("Car Add 테스트")
    @ParameterizedTest
    public void addTest(int size) {
        Cars srcCars = initCars(
                sizeToNames(size),
                BasicCar::new
        );
        Cars cars = new Cars(new HashSet<>());
        for (Car iCar : srcCars)
            cars.add(iCar);

        assertThat(cars.size())
                .isEqualTo(size);
    }

    @CsvSource({
            "5,0,0",
            "5,4,1",
            "5,9,1"
    })
    @DisplayName("moveAll Test")
    @ParameterizedTest
    public void moveAllTest(int carSize, int fuelValue, int locationValue) {
        Cars cars = initCars(sizeToNames(carSize), BasicCar::new);
        Turn turn = new Turn();
        Fuel fuel = new BasicFuel(fuelValue);
        Location location = new Location(locationValue);

        cars.moveAll(turn, fuel);
        for (Car iCar : cars) {
            assertThat(
                    turn.checkLocation(iCar, location)
            ).isTrue();
        }
    }

    @Test
    public void addTest() {
        Cars cars = new Cars(new HashSet<>());
        cars.add(
                new BasicCar(
                        new Name("AAA1")
                )
        );
        cars.add(
                new BasicCar(
                        new Name("AAA2")
                )
        );
        cars.add(
                new BasicCar(
                        new Name("AAA3")
                )
        );
    }

    @Test
    public void addTest_IllegalStateException() {
        assertThatThrownBy(() -> {
            Cars cars = new Cars(new HashSet<>());
            cars.add(
                    new BasicCar(
                            new Name("AAA")
                    )
            );
            cars.add(
                    new BasicCar(
                            new Name("AAA")
                    )
            );
            cars.add(
                    new BasicCar(
                            new Name("AAA")
                    )
            );
        }).isInstanceOf(IllegalStateException.class);
    }
}