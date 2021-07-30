package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 경주 게임 테스트")
public class CarGameTest {
    int carCnt;
    int playCnt;
    CarGame game;

    @BeforeEach
    public void beforeEach() {
        carCnt = 3;
        playCnt = 5;

        game = new CarGame(carCnt);
    }

    @Test
    @DisplayName("자동차수를 입력받아 자동차 수만큼 세팅한다.")
    public void save_cars() {
        assertThat(game.getCarCnt()).isEqualTo(carCnt);

        for (int i=0; i<game.getCarCnt(); i++) {
            int move = game.getCar(i).getMove();
            assertThat(move).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("4이상일 경우 자동차가 전진해야한다.")
    public void car_should_be_moved() {
        //given
        int randomNum = 4;
        int carIdx = 0;

        //when
        game.canMove(carIdx, randomNum);

        //then
        int move = game.getCar(carIdx).getMove();
        assertThat(move).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만일 경우 자동차가 움직이지 않아야한다.")
    public void car_should_be_not_moved() {
        //given
        int randomNum = 3;
        int carIdx = 0;

        //when
        game.canMove(carIdx, randomNum);

        //then
        int move = game.getCar(carIdx).getMove();
        assertThat(move).isEqualTo(0);
    }

    @Test
    @DisplayName("여러개의 랜덤숫자가 주어질 경우 테스트")
    public void car_should_be_moved_or_not() {
        //given
        int carIdx = 0;

        int[] randomNums    = {4, 3, 2, 8, 9};
        int[] expectedMove  = {1, 1, 1, 2, 3};

        for (int i=0; i<randomNums.length; i++) {
            //when
            game.canMove(carIdx, randomNums[i]);

            //then
            int move = game.getCar(carIdx).getMove();
            assertThat(move).isEqualTo(expectedMove[i]);
        }
    }
}
