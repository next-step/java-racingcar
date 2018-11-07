package racing;

import org.junit.Test;
import racing.domain.Car;
import racing.utils.CarRacingUtils;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
public class CarRacingUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void 우승자를_찾을_목록_자체가_NULL인_경우_IllegalArgument_예외가_발생하는지_검사() {
        CarRacingUtils.findWinnders(null);
    }

    @Test
    public void 레이싱_우승자_찾기_우승자는_라이언() {

        final List<Car> cars = Arrays.asList(
                new Car("라이언", 10, () -> false),
                new Car("홍길동", 9, () -> false),
                new Car("제이슨", 8, () -> false)
        );

        final List<Car> byWinnders = CarRacingUtils.findWinnders(cars);
        final List<Car> winners = byWinnders.stream()
                .filter(winner -> "라이언".equals(winner.getName()))
                .collect(toList());

        assertThat(winners.size()).isEqualTo(1);
    }

    @Test
    public void 레이싱_우승자가_여러명인_경우_우승자는_라이언과_제이슨() {

        final List<Car> cars = Arrays.asList(
                new Car("라이언", 10, () -> false),
                new Car("홍길동", 9, () -> false),
                new Car("제이슨", 10, () -> false)
        );

        final List<Car> byWinnders = CarRacingUtils.findWinnders(cars);
        final List<Car> winners = byWinnders.stream()
                .filter(winner -> "라이언".equals(winner.getName()) || "제이슨".equals(winner.getName()))
                .collect(toList());

        assertThat(winners.size()).isEqualTo(2);
    }

    @Test
    public void 레이싱_참가자_모두_공동_우승인_경우() {

        final List<Car> cars = Arrays.asList(
                new Car("라이언", 5, () -> false),
                new Car("홍길동", 5, () -> false),
                new Car("제이슨", 5, () -> false)
        );

        final List<Car> byWinnders = CarRacingUtils.findWinnders(cars);
        final List<Car> winners = byWinnders.stream()
                .filter(winner -> "라이언".equals(winner.getName()) || "홍길동".equals(winner.getName()) || "제이슨".equals(winner.getName()))
                .collect(toList());

        assertThat(winners.size()).isEqualTo(3);
    }

}