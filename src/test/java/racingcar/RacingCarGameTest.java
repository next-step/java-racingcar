package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.ResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    /*
    --------------------------------------------------------------------------------
    - 단위 테스트
    --------------------------------------------------------------------------------
     */

    @Test
    @DisplayName("게임 상태 관리 - 자동차 수, 시도 회수를 저장한다")
    void racing_car_count() {
        RacingCarGame racingCarGame = new RacingCarGame(5, 10);

        assertThat(racingCarGame.carCount()).isEqualTo(5);
        assertThat(racingCarGame.attemptCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("자동차 생성 - 입력한 수만큼 자동차를 생성한다.")
    void create_car_and_count() {
        RacingCarGame racingCarGame = new RacingCarGame(5, 10);
        racingCarGame.createCar();

        assertThat(racingCarGame.carList().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 이동 - 자동차가 이동한다. 이동 카운트가 증가한다")
    void move_car() {
        Car car = new Car();
        car.move();

        assertThat(car.moveCount()).isEqualTo(1);
    }


    @Test
    @DisplayName("랜덤 값 테스트, 입력한 수보다 작은 값으로 랜덤하게 숫자를 반환한다")
    public void random(){
        RacingCarGame racingCarGame = new RacingCarGame(5, 5);
        assertThat(racingCarGame.random(10)).isLessThan(10);
    }

    @Test
    @DisplayName("자동차 이동 조건 - 값이 4 이상인 경우에만 가능하다 ")
    public void movable_check() {
        RacingCarGame racingCarGame = new RacingCarGame(5, 5);

        assertThat(racingCarGame.movable(4)).isTrue();
        assertThat(racingCarGame.movable(5)).isTrue();
        assertThat(racingCarGame.movable(3)).isFalse();
    }



    /*
    ----------------------------------------------------------------------------
    - 통합 테스트
    ----------------------------------------------------------------------------
    - issue
    - @Todo
         1. 랜덤 값 때문에 테스트가 불가능 어떤 방식으로 처리?
    */

    @Test
    @DisplayName("자동차 경주 - 자동차의 이동 카운트가 증가한다")
    void race_start_car_move_count_increase() {
        RacingCarGame racingCarGame = new RacingCarGame(3, 5);
        racingCarGame.createCar();
        racingCarGame.start();

        assertThat(racingCarGame.carList())
                .filteredOn(car -> car.moveCount() > 0)
                .hasSizeGreaterThan(0);
    }
}