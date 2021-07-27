package racing.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.BasicFuel;
import racing.domain.fuel.Fuel;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


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

    @CsvSource({
            "5,0,0",
            "5,4,1",
            "5,9,1"
    })
    @DisplayName("moveAll Test")
    @ParameterizedTest
    public void moveAllTest(int carSize, int fuelValue, int locationValue) {
        Fuel fuel = new BasicFuel(fuelValue);
        Location location = new Location(locationValue);

        Cars cars = initCars(sizeToNames(carSize), Car::new);
        Cars newCars = cars.moveAll(fuel);

        assertThat(cars)
                .isEqualTo(cars);
        assertThat(cars.findWinners())
                .isEqualTo(newCars);
    }

    @DisplayName("findWinners 테스트")
    @Test
    public void findWinnersTest() {
        Set<Car> winnersCarSet = new HashSet<>();
        winnersCarSet.add(new Car(new Name("우승자"), Location.oneBlock()));
        winnersCarSet.add(new Car(new Name("우승자2"), Location.oneBlock()));

        Set<Car> carList = new HashSet<>();
        carList.add(new Car(new Name("패배자"), Location.empty()));

        carList.addAll(winnersCarSet);

        Cars expertWinners = new Cars(winnersCarSet);
        Cars cars = new Cars(carList);
        Cars winners = cars.findWinners();

        assertThat(expertWinners)
                .isEqualTo(winners);
    }
}