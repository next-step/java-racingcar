package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class racingCarTest {

    @Test
    @DisplayName("입력한 자동차 중 가장 많이 전진한 자동차 이름을 반환한다.")
    public void 가장_많이_전진한_자동차_이름_반환(){
        NamedCars namedCars = new NamedCars(Arrays.asList(
                new Car("pobi", 5),
                new Car("crong", 3),
                new Car("honux", 5)));

        List<String> winners = WinnerCar.returnWinner(namedCars);

        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactly("pobi","honux");
    }

    @Test
    @DisplayName("입력한 자동차 중 가장 많이 전진한 자동차의 전진 횟수를 반환한다.")
    public void 가장_많이_전진한_자동차_전진횟수_반환(){
        NamedCars namedCars = new NamedCars(Arrays.asList(
                new Car("pobi", 5),
                new Car("crong", 3),
                new Car("honux", 5)));

        assertThat(namedCars.getMaxForward()).isEqualTo(5);
    }

    @Test
    @DisplayName("입력한 여러대의 자동차 이름을 콤마 구분자로 구분하여 자동차 이름을 부여하고 0번 움직인 결과를 반환한다.")
    public void 자동차_경주_초기_설정(){
        String carNames = "pobi,crong,honux";

        NamedCars cars = new NamedCars(carNames);

        assertAll(
                () -> assertThat(cars.findCar("pobi").equals(new Car("pobi", 0))).isTrue(),
                () -> assertThat(cars.findCar("crong").equals(new Car("crong", 0))).isTrue(),
                () -> assertThat(cars.findCar("honux").equals(new Car("honux", 0))).isTrue()
        );
    }

    @Test
    @DisplayName("자동차 이름이 최대 길이를 초과할 경우 예외를 발생한다.")
    public void 자동차_이름_최대_길이_초과(){
        assertThatThrownBy(() -> {
            assertThat(new Car("abcedf",0));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름을 입력할 경우 해당 이름을 가진 자동차 객체를 생성한다.")
    public void 자동차_이름_부여(){
        Car car = new Car("pobi",0);
        assertThat(car.getCarName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("입력한 횟수만큼 자동차 한대를 움직인 결과를 반환한다. ")
    public void 자동차_한대를_입력_횟수_만큼_움직인_결과(){
        Cars cars = new Cars(1);
        int[] result = RacingCar.movingResult(cars.carArray,5);
        assertThat(result[0]).isBetween(0,5);
    }

    @Test
    @DisplayName("입력한 자동차 대수를 한 번 움직인 결과로 1 또는 0으로 이루어진 숫자 배열을 반환한다.")
    public void 입력한_자동차_대수를_한번_움직인_결과(){
        Cars cars = new Cars(3);
        int[] movingResult = RacingCar.addMoving(cars.carArray);

        assertThat(movingResult).hasSize(3);
        for(int i=0; i<3; i++) {
            assertThat(movingResult[i]).isBetween(0, 1);
        }
    }

    @Test
    @DisplayName("입력값이 3이하일 경우 0(정지)을 반환하고, 4이상일 경우 1(전진)을 반환한다.")
    public void 정지_또는_전진_조건_테스트(){
        assertThat(Car.isMoveCar(3)).isFalse();
        assertThat(Car.isMoveCar(4)).isTrue();
    }

    @Test
    @DisplayName("0에서 9사이의 랜덤값을 반환한다.")
    public void 랜덤값_추출_0과_9사이_정수(){
        int random = RandomNumber.getRandom(10);
        assertThat(random).isBetween(0,9);
    }
}
