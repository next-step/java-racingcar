package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarListTest {

    @Test
    void Test_extractWinners_succeed() {
        // given
        CarList carList = CarList.generateCarList(
                getDummyCars().stream().map(SimpleCar::getCarName).collect(Collectors.toList()));

        // when
        List<SimpleCar> winners = carList.extractWinners();

        // then
        assertThat(winners).isNotEmpty();
    }

    @Test
    void Test_extractWinners_fail() {
        // given
        CarList carList = CarList.generateCarList(List.of());

        // when, then
        assertThrows(NoSuchElementException.class, carList::extractWinners);
    }

    private List<SimpleCar> getDummyCars() {
        return List.of("a", "bb", "ccc").stream()
                .map(SimpleCar::new).collect(Collectors.toList());
    }

    @Test
    void Given_CarNames_too_long_When_generateCars_Then_fail_to_generate_cars() {
        // given
        List<String> carNames = List.of("1", "22", "333", "4444", "55555", "666666");
        GameStartParameter gameStartParameter = new GameStartParameter(carNames, 5);

        // when, then
        assertThrows(IllegalArgumentException.class, () -> CarList.generateCarList(gameStartParameter.getCarNames()));
    }

    @Test
    void Given_GameStartParameters_When_generateCars_Then_cars_generated() {
        // given
        List<String> carNames = List.of("1", "22", "333", "4444", "55555");
        GameStartParameter gameStartParameter = new GameStartParameter(carNames, 5);

        // when
        List<SimpleCar> cars = CarList.generateCarList(gameStartParameter.getCarNames()).getCopiedCars();

        // then
        assertThat(cars.size()).isEqualTo(carNames.size());
        assertThat(cars.stream().filter(it -> it.getCarName().equals("333")).findAny()).isPresent();
    }

}
