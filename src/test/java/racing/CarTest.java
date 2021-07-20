package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private static Car car;

    void initTestSetup(String inputValue) {
        System.setIn(new ByteArrayInputStream(inputValue.getBytes()));
        car = new Car();
    }

    @Test
    @DisplayName("경주에 참가할 자동차 대수를 입력하면 대수만큼 자동차가 생성된다.")
    public void create_carModel() {
        initTestSetup("4\n");
        car.car_racing();

        assertThat(car.getCarList()).extracting("carNumber").containsExactly(1, 2, 3, 4);
        assertThat(car.getCarList().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("랜덤 숫자 함수를 실행하면 0이상 10미만의 숫자가 생성된다.")
    public void create_random_number() {
        initTestSetup("");
        int result = car.randomIntValue();

        assertThat(result).isGreaterThan(0).isLessThan(10);
    }

    @Test
    @DisplayName("랜덤 숫자가 4이상이면 경주에 사용되는 자동차가 전진한다.")
    public void racing_random_number_check() {
        initTestSetup("");
        String raceDistance1 = car.getRaceDistance(4);
        String raceDistance2 = car.getRaceDistance(3);

        assertThat(raceDistance1).isEqualTo("-");
        assertThat(raceDistance2).isEqualTo("");
    }

    @Test
    @DisplayName("입력값에 숫자가 아닌 문자를 입력시 예외가 발생된다.")
    public void inputValue_notNumber_check() {
        initTestSetup("ㅁ\n");
        assertThatThrownBy(() -> car.car_racing())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 문자는 숫자만 사용 가능합니다.");
    }

    @Test
    @DisplayName("경주 시도 횟수만큼 참가한 차는 경주를 진행한다.")
    public void racingByCar() {
        initTestSetup("3\n6\n");
        car.car_racing();

    }
}
