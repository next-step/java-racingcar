package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.generator.RandomGenerator;
import racingcar.ui.InputView;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingCarTest {

    private static final int CAR = 3;
    Car car;
    Cars cars;

    @BeforeEach
    void setUp() {
        car = new Car(); // 1로 초기화
        cars = new Cars(RacingCar.getCars(CAR));
    }

    @Test
    @DisplayName("전진 조건에 만족하면 전진")
    void move() {
        car.move(() -> true);
        assertThat(car.getMoveCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("전진 조건에 만족하지 않으면 멈춤")
    void stop() {
        car.move(() -> false);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 조건에 만족하면 모두 전진")
    void moveAll() {
        cars.moveAll(() -> true);

        assertAll(
                () -> assertThat(cars.getCurrentStatus().get(0).getMoveCount()).isEqualTo(2),
                () -> assertThat(cars.getCurrentStatus().get(1).getMoveCount()).isEqualTo(2),
                () -> assertThat(cars.getCurrentStatus().get(2).getMoveCount()).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("전진 조건에 만족하지 않으면 모두 멈춤")
    void stopAll() {
        cars.moveAll(() -> false);

        assertAll(
                () -> assertThat(cars.getCurrentStatus().get(0).getMoveCount()).isEqualTo(1),
                () -> assertThat(cars.getCurrentStatus().get(1).getMoveCount()).isEqualTo(1),
                () -> assertThat(cars.getCurrentStatus().get(2).getMoveCount()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("random 값은 0과 9사이 값")
    void random() {
        assertThat(RandomGenerator.generate()).isBetween(0, 9);
    }

    @Test
    @DisplayName("자동차 대수가 0보다 작을 경우 오류 리턴")
    void inputCar() {
        String input = "0";
        InputView.setScanner(new Scanner(new ByteArrayInputStream(input.getBytes())));

        assertThatThrownBy(InputView::inputValidatedNumberOfCar)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도할 회수가 0보다 작을 경우 오류 리턴")
    void inputAttempts() {
        String input = "0";
        InputView.setScanner(new Scanner(new ByteArrayInputStream(input.getBytes())));

        assertThatThrownBy(InputView::inputValidatedNumberOfAttempts)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("반환된 자동차 List의 크기는 입력된 크기와 같다.")
    public void getCars() {
        List<Car> cars = RacingCar.getCars(CAR);
        assertThat(cars.size()).isEqualTo(CAR);
    }

    @Test
    @DisplayName("자동차 이름이 공란일 경우 오류 리턴")
    void inputCarName_empty() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과할 경우 오류 리턴")
    void inputCarName_5자초과() {
        assertThatThrownBy(() -> new Car("hyundai"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 중복될 경우 오류 리턴")
    void inputCarName_중복된이름() {
        String[] names = {"pobi", "pobi"};
        assertThatThrownBy(() -> Cars.fromNames(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름은 쉼표로 구분")
    void inputCarName_split() {
        String input = "pobi,crong,honux";
        InputView.setScanner(new Scanner(new ByteArrayInputStream(input.getBytes())));
        assertThat(InputView.inputdNameOfCar()).containsExactly(input.split(","));

    }

    @Test
    @DisplayName("단일 우승자 결정 ")
    void getWinner() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Cars cars = new Cars(List.of(pobi, crong));
        pobi.move(() -> true);

        assertThat(cars.getWinners()).containsExactly("pobi");
    }

    @Test
    @DisplayName("공동 우승자 결정 ")
    void getWinners() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Cars cars = new Cars(List.of(pobi, crong));

        assertThat(cars.getWinners()).containsExactly("pobi", "crong");
    }

}
