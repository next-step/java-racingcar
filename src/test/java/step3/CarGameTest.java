package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Cars;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 경주 게임 테스트")
public class CarGameTest {
    int carCnt = 3;

    @Test
    @DisplayName("자동차수를 입력받아 자동차 수만큼 세팅한다.")
    public void set_cars() {
        Cars cars = new Cars(carCnt);
        assertThat(cars.getCarCnt()).isEqualTo(carCnt);

        for (int i=0; i<cars.getCarCnt(); i++) {
            int move = cars.getCar(i).getMove();
            assertThat(move).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("4이상일 경우 자동차가 전진해야한다.")
    public void car_should_be_moved() {
        //given
        int carIdx = 0;

        //when
        Cars cars = new Cars(carCnt);
        cars.move(carIdx, ()->true);

        //then
        int move = cars.getCar(carIdx).getMove();
        assertThat(move).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만일 경우 자동차가 움직이지 않아야한다.")
    public void car_should_be_not_moved() {
        //given
        int randomNum = 3;
        int carIdx = 0;

        //when
        Cars cars = new Cars(carCnt);
        cars.move(carIdx, ()->false);

        //then
        int move = cars.getCar(carIdx).getMove();
        assertThat(move).isEqualTo(0);
    }

    @Test
    @DisplayName("여러개의 랜덤숫자가 주어질 경우 테스트")
    public void car_should_be_moved_or_not() {
        //given
        int carIdx = 0;

        boolean[] randomNums = {true, false, false, true, true};
        int[] expectedMove = {1, 1, 1, 2, 3};

        Cars cars = new Cars(carCnt);

        for (int i=0; i<randomNums.length; i++) {
            //when
            boolean random = randomNums[i];
            cars.move(carIdx, ()->random);

            //then
            int move = cars.getCar(carIdx).getMove();
            assertThat(move).isEqualTo(expectedMove[i]);
        }
    }
}
