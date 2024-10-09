package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class RaceGameTest {

    public static final String CAR_NAMES = "pobi, jason, jobi";

    private static Cars createCars(String 경주할_자동차_이름) {
        return new Cars(경주할_자동차_이름);
    }

    @Test
    void playRounds() {
        // Given & When
        UserInputData userInputData = new UserInputData(CAR_NAMES, 1);
        RaceGame raceGame = new RaceGame(userInputData);

        MoveStrategy moveStrategy = new ForwardStrategy(new RandomNumberGenerator()) {
            @Override
            public boolean isMovable() {
                return true;
            }
        };

        // Then
        assertAll(
                () -> assertThat(raceGame.playGame(moveStrategy)).isNotNull(),
                () -> assertThat(raceGame.playGame(moveStrategy).size()).isOne()
        );
    }

    @Test
    @DisplayName("생성한 자동차의 현재 위치를 검증한다.")
    void playRound() {
        // Given
        MoveStrategy moveStrategy = new ForwardStrategy(new RandomNumberGenerator()) {
            @Override
            public boolean isMovable() {
                return true;
            }
        };
        Records records = new Records();
        Cars cars = createCars(CAR_NAMES);

        // When
        for (Car car : cars.getCars()) {
            car.move(moveStrategy);
            records.save(new Record(car.getPosition(),car.getName().getValue()));
        }

        // Then
        Record result = records.getRecords().get(0);
        assertThat(result.getPosition()).isOne();
    }

}