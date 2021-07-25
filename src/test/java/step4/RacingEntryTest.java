package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingEntryTest {

    private final List<String> carNames = Stream.of("pobi", "crong", "honux").collect(Collectors.toList());

    private RacingEntry racingEntry;

    @BeforeEach
    void init() {
        this.racingEntry = new RacingEntry(carNames);
    }

    @Test
    @DisplayName("RacingEntry 생성자 테스트")
    void racingEntryTest() {
        assertThat(racingEntry.getCars().size()).isEqualTo(3);

        List<String> carNames = racingEntry.getCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(carNames).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("우승자를 찾는 테스트")
    void findWinnerTest() {
        this.racingEntry = new RacingEntry(Stream.of("w", "l1", "l2").collect(Collectors.toList()));

        // 첫번째 차만 100턴 진행
        IntStream.range(0, 100)
                .forEach(x -> this.racingEntry.getCars().get(0).goOrStop());

        List<Car> winners = this.racingEntry.findWinners();

        assertThat(winners.size()).isEqualTo(1);

        assertThat(winners.get(0).getName()).isEqualTo("w");
    }
}
