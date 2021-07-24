package racingcargame.domain.vehicle;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcargame.domain.common.Name;
import racingcargame.domain.common.Names;
import racingcargame.domain.vehicle.factory.AllwaysForwardCarFactory;
import racingcargame.domain.vehicle.factory.CarFactory;
import racingcargame.domain.vehicle.factory.NormalCarFactory;

@DisplayName("자동차들")
class CarsTest {

    private final CarFactory normalCarFactory = new NormalCarFactory();
    private final CarFactory allwaysForwardCarFactory = new AllwaysForwardCarFactory();

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honux,hyune")
    public void create(String nameString) {
        // given
        Names names = new Names(nameString, ",");
        List<Car> carList = names.getNames()
            .stream()
            .map(normalCarFactory::create)
            .collect(Collectors.toList());

        // when
        Cars cars = new Cars(carList);

        // then
        assertThat(cars.getCars().size()).isEqualTo(4);
    }

    @DisplayName("[성공] 우승")
    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honux,hyune")
    public void winners(String nameString) {
        // given
        Names names = new Names(nameString, ",");
        List<Car> carList = names.getNames()
            .stream()
            .map(normalCarFactory::create)
            .collect(Collectors.toList());
        Name winnerName1 = new Name("win1");
        Name winnerName2 = new Name("win2");
        carList.add(allwaysForwardCarFactory.create(winnerName1));
        carList.add(allwaysForwardCarFactory.create(winnerName2));

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
