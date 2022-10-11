package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    @DisplayName("입력받은 carName의 길이와 실제 차의수가 같아야함")
    @ParameterizedTest(name = "{displayName} {index} parameter=\"{0}\"")
    @CsvSource(value = {"qwe,asd,zxc:3", "a:2", "a,b,c:1"}, delimiter = ':')
    void start_carName(String carName, int iterate) {
        String[] carNames = carName.split(",");
        Racing racing = new Racing(carNames, iterate, new RandomStrategy());
        racing.start();

        List<Car> cars = racing.getCars();
        assertThat(cars.size()).isEqualTo(carNames.length);
    }

    @DisplayName("입력받은 iterate의 길이와 Car의 경기기록 길이가 감아야함")
    @ParameterizedTest(name = "{displayName} {index} parameter=\"{0}\"")
    @CsvSource(value = {"qwe,asd,zxc:3", "a:2", "a,b,c:1"}, delimiter = ':')
    void start_iterate(String carName, int iterate) {
        String[] carNames = carName.split(",");
        Racing racing = new Racing(carNames, iterate, new RandomStrategy());
        racing.start();
        List<Car> cars = racing.getCars();

        for (Car car : cars) {
            assertThat(car.getRecord().getRecord().size()).isEqualTo(iterate);
        }
    }

    @DisplayName("Car가 한개인 경우 해당 한개인 Car를 우승자로 반환해야 함")
    @Test()
    void getWinnersOneCar() {
        String[] carNames = {"kero"};
        int iterate = 2;
        Racing racing = new Racing(carNames, iterate, new RandomStrategy());
        racing.start();
        List<String> winners = racing.getWinners();
        assertThat(winners).contains("kero");
    }

    static Stream<Arguments> getWinnersMultiCarsParam() {
        int iterate = 10;
        return Stream.of(
                Arguments.arguments(
                        new ArrayList<>(List.of(
                                new Car("kero", () -> true),
                                new Car("zero", () -> false)
                        )),
                        iterate,
                        List.of("kero")
                ),
                Arguments.arguments(
                        new ArrayList<>(List.of(
                                new Car("kero", () -> true),
                                new Car("zero", () -> true)
                        )),
                        iterate,
                        List.of("kero", "zero")
                ),
                Arguments.arguments(
                        new ArrayList<>(List.of(
                                new Car("kero", () -> false),
                                new Car("giro", () -> false),
                                new Car("zero", () -> true)
                        )),
                        iterate,
                        List.of("zero")
                ),
                Arguments.arguments(
                        new ArrayList<>(List.of(
                                new Car("kero", () -> false),
                                new Car("giro", () -> true),
                                new Car("zero", () -> true)
                        )),
                        iterate,
                        List.of("giro", "zero")
                )
        );
    }

    @DisplayName("getWinners()는 가장많이 전진한 Car를 우승자로 반환해야 함")
    @ParameterizedTest(name = "{displayName} {index} 우승자: {2}")
    @MethodSource("getWinnersMultiCarsParam")
    void getWinnersMultiCars(List<Car> cars, int iterate, List<String> expectedWinners) {
        Racing racing = new Racing(cars, iterate);
        racing.start();
        List<String> winners = racing.getWinners();

        expectedWinners.forEach(expectedWinner -> assertThat(winners).contains(expectedWinner));
        System.out.println("winners = " + winners);
        System.out.println("expectedWinners = " + expectedWinners);
    }
}