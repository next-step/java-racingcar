package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RaceControllTest {

    @DisplayName("레이싱카 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"ALO,LEC,SAI", "HAM,BOT,VER"})
    void registrationCarsTest(String names) {
        RaceControll raceControll = new RaceControll(names);
        List<RacingCar> cars = raceControll.getCars();
        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("단일 우승자 조회")
    @Test
    void singleWinner() {
        String drivers = "LEC,SAI,ALO";
        RaceControll raceControll = new RaceControll(drivers);
        raceControll.getCars().stream()
                .filter(car -> car.getDriver().getName().equals("LEC"))
                .forEach(car -> {
                    car.attack(true);
                });

        String actual = raceControll.getWinners().stream().map(Driver::getName).collect(Collectors.joining(", "));

        assertThat(actual).isEqualTo("LEC");
    }

    @DisplayName("다수 우승자 조회")
    @Test
    void multipleWinners() {
        String drivers = "LEC,SAI,ALO";
        RaceControll raceControll = new RaceControll(drivers);
        raceControll.getCars().stream()
                .filter(car -> car.getDriver().getName().equals("LEC") || car.getDriver().getName().equals("SAI"))
                .forEach(car -> {
                    car.attack(true);
                });

        String actual = raceControll.getWinners().stream().map(Driver::getName).collect(Collectors.joining(", "));

        assertThat(actual).isEqualTo("LEC, SAI");
    }

}