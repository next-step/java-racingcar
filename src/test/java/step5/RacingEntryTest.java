package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingEntryTest {

    private final List<Car> cars = Stream.of(new Car("pobi"), new Car("crong"), new Car("honux"))
            .collect(Collectors.toList());

    private RacingEntry racingEntry;

    @BeforeEach
    void init() {
        this.racingEntry = new RacingEntry(cars);
    }

    @Test
    @DisplayName("RacingEntry 생성자 테스트")
    void racingEntryTest() {
        assertThat(racingEntry.getCars().size()).isEqualTo(3);

        List<String> carNames = racingEntry.getCars().stream()
                .map(Car::getCarName)
                .map(CarName::getValue)
                .collect(Collectors.toList());

        assertThat(carNames).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("우승자를 찾는 테스트")
    void findWinnerTest() {
        // 첫번째 차만 100턴 진행
        IntStream.range(0, 10).forEach(x -> this.racingEntry.getCars().get(0).goOrStop(() -> true));
        IntStream.range(0, 10).forEach(x -> this.racingEntry.getCars().get(1).goOrStop(() -> true));

        List<Car> winners = this.racingEntry.findWinnerCars();

        assertThat(winners.size()).isEqualTo(2);

        assertThat(winners.stream()
                .map(Car::getCarName)
                .map(CarName::toString)
                .collect(Collectors.toList())).contains("pobi", "crong");
    }
}
