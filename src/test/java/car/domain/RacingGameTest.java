package car.domain;

import car.Car;
import car.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingGameTest {

    List<Car> participants;

    @BeforeEach
    void setUp() {
        participants = new ArrayList<>();
        participants.add(new Car("씽씽카", 5));
        participants.add(new Car("쏘카", 3));
        participants.add(new Car("그린카", 5));
    }

    @Test
    void 자동차_전진횟수를_최댓값을_구한다() {
        // given
        int expected = 5;

        //when
        int actual = getMaxPosition(participants);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차_경주_우승자를_구한다() {
        // given
        int maxValue = 5;

        // when
        List<Car> winners = getWinners(participants, maxValue);

        // then
        System.out.println("최종 우승자: " + winners);
        assertThat(winners).hasSize(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"씽씽카,소카,그린카:5"}, delimiter = ':')
    void 자동차_경주_게임을_시작한다(String carNames, int moveCount) {

        //given
        String[] cars = carNames.split(",");
        List<Car> participants = new ArrayList<>();

        for (String carName : cars) {
            participants.add(new Car(carName));
        }

        //when
        List<Car> winners = play(participants, moveCount);
        System.out.println("Winner: " + winners);
    }

    public List<Car> play(List<Car> participants, int moveCount) {

        for (int i = 0; i < moveCount; i++) {
            startMoveRandomly(participants);
        }

        int maxPosition = getMaxPosition(participants);
        return getWinners(participants, maxPosition);
    }

    private void startMoveRandomly(List<Car> participants) {
        participants.forEach(participant -> {
            int randomValue = RandomUtils.generateRandomValue();
            participant.move(randomValue);
        });
        System.out.println();
    }

    private List<Car> getWinners(List<Car> participants, int maxPosition) {
        return participants.stream().
                filter(participant -> maxPosition == participant.getPosition())
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> participants) {

        int maxPosition = 0;

        for (Car car : participants) {
            maxPosition = calcMaxPosition(maxPosition, car);
        }

        return maxPosition;
    }

    private int calcMaxPosition(int maxPosition, Car car) {
        if (maxPosition < car.getPosition()) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }
}
