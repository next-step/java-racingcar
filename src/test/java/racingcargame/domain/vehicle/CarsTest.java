package racingcargame.domain.vehicle;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcargame.domain.common.Name;
import racingcargame.domain.vehicle.factory.AlwaysForwardCarFactory;
import racingcargame.domain.vehicle.factory.CarFactory;
import racingcargame.domain.vehicle.factory.NormalCarFactory;

@DisplayName("자동차들")
class CarsTest {

    private final CarFactory normalCarFactory = new NormalCarFactory();
    private final CarFactory alwaysForwardCarFactory = new AlwaysForwardCarFactory();

    @DisplayName("[성공] 우승")
    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honux,hyune")
    public void winners(String nameString) {
        // given
        List<Name> names = Arrays.stream(nameString.split(","))
            .map(Name::new)
            .collect(Collectors.toList());
        List<Car> carList = names.stream()
            .map(normalCarFactory::create)
            .collect(Collectors.toList());
        Name winnerName1 = new Name("win1");
        Name winnerName2 = new Name("win2");
        carList.add(alwaysForwardCarFactory.create(winnerName1));
        carList.add(alwaysForwardCarFactory.create(winnerName2));

        Cars cars = new Cars(carList);

        // when
        for (int i = 0; i < 100; i++) {
            cars.doDrive();
        }

        // then
        WinnerCars winners = cars.getWinners();
        List<Name> winnerNames = winners.getNames();
        assertThat(winnerNames).contains(winnerName1, winnerName2);
    }
}
