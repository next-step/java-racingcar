import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("난수가 4이상일때 거리 증가")
    public void moveTest() {
        //given
        Car car = new Car("aaa");
        int randomNumber = 4;
        int moveCount = car.getMoveCount();

        //when
        car.move(randomNumber);

        //then
        assertThat(car.getMoveCount()).isEqualTo(moveCount + 1);
    }

    @Test
    @DisplayName("난수가 4미만일때 거리변화 없음")
    public void notMoveTest() {
        //given
        Car car = new Car("aaa");
        int randomNumber = 2;
        int moveCount = car.getMoveCount();

        //when
        car.move(randomNumber);

        //then
        assertThat(car.getMoveCount()).isEqualTo(moveCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1", "5:1", "6:1"}, delimiter = ':')
    @DisplayName("난수가 4미만일때 거리변화 없음 5이상일경우 변화 있음")
    public void 난수의조건을모두체크(int randomNumber, int changedMoveCount) {
        //given
        Car car = new Car("aaa");

        //when
        car.move(randomNumber);

        //then
        assertThat(changedMoveCount).isEqualTo(car.getMoveCount());
    }

    @ParameterizedTest
    @CsvSource(value= {"aaa","bbb","ccc"})
    @DisplayName("자동차 이름이 전부 5자 이내인 자동차 생성")
    public void makeCarTest(String name) {
        assertThat(new Car(name).getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름이 5자 초과면 에러")
    @ParameterizedTest
    @CsvSource(value = {"123456","1234567","12345678"})
    public void invalidMakeCarTest(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car(name);
                });
    }

    @Test
    void isWinner() {
        //given
        Car car = new Car("aaa");
        Car car2 = new Car("aab");

        //when
        car.move(4);
        car.move(5);
        car.move(6);
        car2.move(4);
        car2.move(4);

        //then
        assertThat(car.isWinner(3)).isTrue();
    }
}
