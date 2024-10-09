package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class RaceGameTest {

    private static Cars createCars(int 생성할_자동차_대수) {
        return new Cars(생성할_자동차_대수);
    }

    @Test
    void playRounds() {
        // Given & When
        UserInputData userInputData = new UserInputData(1, 1);
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
        Positions positions = new Positions();
        Cars cars = createCars(1);

        // When
        for (Car car : cars.getCars()) {
            car.move(moveStrategy);
            positions.save(new Position(car.getPosition()));
        }

        // Then
        Position result = positions.getPositions().get(0);

        assertThat(result.getValue()).isOne();
    }

}