package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void startGame_NonMoveTest() {
        Cars cars = new Cars(2);
        RacingGame racingGame = new RacingGame(2, cars);
        racingGame.startGame(new NonMove());
        cars.getCarDTOs()
            .forEach(carDTO -> assertThat(carDTO.getPosition()).isEqualTo(0));
    }

    @Test
    void startGame_MoveOneSpaceTest() {
        Cars cars = new Cars(2);
        RacingGame racingGame = new RacingGame(2, cars);
        racingGame.startGame(new MoveOneSpace());
        cars.getCarDTOs()
            .forEach(carDTO -> assertThat(carDTO.getPosition()).isEqualTo(2));
    }

}