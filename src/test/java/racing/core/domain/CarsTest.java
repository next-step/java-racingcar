package racing.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.core.dto.TrackInfo;
import racing.core.dto.Trial;
import racing.core.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {

    private String[] names = {"test1", "test2", "test3"};

    @Test
    @DisplayName("생성자에서 리스트에 대한 검증")
    void createCars() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Cars cars = new Cars(new ArrayList<>());
        }).withMessage(ErrorMessage.EMPTY_CARS.getMessage());
    }

    @Test
    @DisplayName("모든 자동차가 이동한 trial 결과 테스트")
    void nextTrialAllMoved() {
        // given
        Cars cars = new Cars(Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList()));

        // when
        Trial actual = cars.nextTrial(() -> true);

        // then
        List<TrackInfo> tracks = Arrays.stream(names)
                .map(name -> new TrackInfo(name, 1))
                .collect(Collectors.toList());
        Trial expected = new Trial(tracks);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("모든 자동차가 정지한 trial 결과 테스트")
    void nextTrialAllStopped() {
        // given
        Cars cars = new Cars(Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList()));

        // when
        Trial actual = cars.nextTrial(() -> false);

        // then
        List<TrackInfo> tracks = Arrays.stream(names)
                .map(name -> new TrackInfo(name, 0))
                .collect(Collectors.toList());
        Trial expected = new Trial(tracks);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("trial 결과 테스트")
    void nextTrial() {
        // given
        Car first = new Car(names[0]);
        Car second = new Car(names[1]);
        Car third = new Car(names[2]);

        Cars cars = new Cars(Arrays.asList(first, second, third));

        first.move(() -> true);

        // when
        Trial actual = cars.nextTrial(() -> false);

        // then
        Trial expected = new Trial(Arrays.asList(
                new TrackInfo(first.getName(), 1),
                new TrackInfo(second.getName(), 0),
                new TrackInfo(third.getName(), 0)
        ));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("우승자 이름 테스트")
    void getNameOfWinner() {
        // given
        Car winner = new Car(names[0]);
        Car second = new Car(names[1]);
        Car third = new Car(names[2]);

        winner.move(() -> true);

        Cars cars = new Cars(Arrays.asList(winner, second, third));
        cars.nextTrial(() -> false);

        // when
        List<String> actual = cars.getNamesOfWinners();

        // then
        List<String> expected = Arrays.asList(winner.getName());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("공통 우승자 이름 테스트")
    void getNamesOfWinners() {
        // given
        Cars cars = new Cars(Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList()));
        cars.nextTrial(() -> true);

        // when
        List<String> actual = cars.getNamesOfWinners();

        // then
        List<String> expected = Arrays.asList(names);
        assertEquals(expected, actual);
    }
}
