package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

class CarTest {

    private Car car;
    private int beforePosition;

    @BeforeEach
    void init() throws NoSuchFieldException, IllegalAccessException {
        car = Car.create("name", 0);
        beforePosition = getCarPositionByReflection(car);
    }

    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest(name = "{arguments} 입력시, 자동차는 이동하지 않는다.")
    void nonForwardTest(int command) throws Exception {
        car.action(mockRandomValue(command));
        int afterPosition = getCarPositionByReflection(car);

        assertThat(afterPosition).isEqualTo(beforePosition);
    }

    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest(name = "{arguments} 입력시, 자동차는 한칸 전진한다.")
    void forwardTest(int command) throws Exception {
        car.action(mockRandomValue(command));
        int afterPosition = getCarPositionByReflection(car);
        assertThat(afterPosition).isEqualTo(beforePosition + 1);
    }

    @Test
    @DisplayName("forward()를 호출하면, 차가 한칸 전진한다.")
    void forwardMethodTest() throws NoSuchFieldException, IllegalAccessException {
        car.forward();
        int afterPosition = getCarPositionByReflection(car);

        assertThat(afterPosition).isEqualTo(beforePosition + 1);
    }

    @ValueSource(ints = {10, 5, 3, 1})
    @ParameterizedTest(name = "[{arguments}] 자동차의 position에 따라, 알맞는 거리를 반환한다.")
    void getDistanceByPositionTest(int position) {
        IntStream.range(0, position)
            .forEach(i -> car.forward());

        assertThat(car.getPosition()).isEqualTo(position);
    }

    @Test
    @DisplayName("자동차별로 이름이 존재해야 한다.")
    void carNameTest() {
        assertThat(car.getName()).isEqualTo("name");
    }

    @ValueSource(strings = "kiyeon")
    @ParameterizedTest(name = "자동차 이름은 5자를 초과할수 없다.")
    void carNameLengthLimitTest(String outBoundCarName) {

        assertThatIllegalArgumentException()
            .isThrownBy(() -> Car.create(outBoundCarName));

    }

    private Random mockRandomValue(int testValue) {
        return new Random() {
            @Override
            public int nextInt(int bound) {
                return testValue;
            }
        };
    }

    private int getCarPositionByReflection(Car car)
        throws NoSuchFieldException, IllegalAccessException {

        Field positionField = Car.class.getDeclaredField("position");
        positionField.setAccessible(true);

        return (int) positionField.get(car);
    }

}