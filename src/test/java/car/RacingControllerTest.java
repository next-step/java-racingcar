package car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.controller.RacingController;
import car.model.Car;
import car.model.Cars;
import car.model.util.RandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingControllerTest {

    @Test
    @DisplayName("시도 횟수가 양수여야지 게임 실행 가능")
    void isLeftRound_확인_양수() {
        assertThatCode(() -> new RacingController("jj, jjj", 1)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수가 음수이면, 게임 실행 불가")
    void isLeftRound_확인_음수() {
        assertThrows(IllegalArgumentException.class, () -> new RacingController("jj,jjj", -1));
    }

    @Test
    @DisplayName("시도 횟수에 따라 레이스가 정상 동작한다.")
    void 시도_횟수_바탕으로_레이스_정상_동작() {
        assertThatCode(() -> new RacingController("jj, jjj", 3).run()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수보다 레이스 횟수가 많으면 오류")
    void 시도_횟수_레이스_오류() {
        // given
        RacingController racingController = new RacingController("jj, jjj", 1);
        // when
        racingController.run();
        // then
        assertThrows(IllegalArgumentException.class,
            () -> racingController.runRaceOnce(new RandomNumberGenerator()));
    }


    @Test
    @DisplayName("winner 찾기")
    void 우승자_찾는_메서드() {
        // given
        List<Car> cars = List.of(new Car("he1", 1),
            new Car("he2", 2),
            new Car("he3", 3));
        RacingController racingController = new RacingController(new Cars(cars), 0);
        // when
        List<Car> winner = racingController.selectWinner();
        // then
        assertThat(winner).extracting("name").contains("he3");
    }


    @Test
    @DisplayName("winner 복수 찾기")
    void 우승자_여러명_찾는_메서드() {
        // given
        List<Car> cars = List.of(new Car("he1", 1),
            new Car("he2", 3),
            new Car("he3", 3));
        RacingController racingController = new RacingController(new Cars(cars), 0);
        // when
        List<Car> winner = racingController.selectWinner();
        // then
        assertThat(winner).extracting("name").contains("he2", "he3");
    }

}
