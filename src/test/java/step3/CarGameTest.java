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
        //given
        Cars carSet = new Cars(carCnt);

        //then
        carSet.getCars().forEach(car -> {
            assertThat(car.getMove()).isEqualTo(0);
        });
    }

    @Test
    @DisplayName("4이상일 경우 자동차가 전진해야한다.")
    public void car_should_be_moved() {
        //given
        Cars carSet = new Cars(carCnt);

        //when
        carSet.moveAll(()->true);

        //then
        carSet.getCars().forEach(car -> {
            assertThat(car.getMove()).isEqualTo(1);
        });
    }

    @Test
    @DisplayName("4미만일 경우 자동차가 움직이지 않아야한다.")
    public void car_should_be_not_moved() {
        //given
        Cars carSet = new Cars(carCnt);

        //when
        carSet.moveAll(()->false);

        //then
        carSet.getCars().forEach(car -> {
            assertThat(car.getMove()).isEqualTo(0);
        });
    }

    @Test
    @DisplayName("여러개의 랜덤숫자가 주어질 경우 테스트")
    public void car_should_be_moved_or_not() {
        //given
        boolean[] randomNums = {true, false, false, true, true};
        int[] expectedMove = {1, 1, 1, 2, 3};

        Cars carSet = new Cars(carCnt);

        for (int i=0; i<randomNums.length; i++) {
            //when
            int expect = expectedMove[i];
            boolean random = randomNums[i];
            carSet.moveAll(()->random);

            //then
            carSet.getCars().forEach(car -> {
                assertThat(car.getMove()).isEqualTo(expect);
            });
        }
    }
}
