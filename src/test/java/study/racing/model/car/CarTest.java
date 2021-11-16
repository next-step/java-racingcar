package study.racing.model.car;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import study.racing.model.Distance;
import study.racing.model.Name;
import study.racing.model.rule.Rule;

public class CarTest {

    public static final int MOVE_COUNT = 1;
    public static final int STOP_COUNT = 0;

    @DisplayName("Rule에 따라 움직이는지 멈추는지 동작을 검증")
    @ParameterizedTest
    @MethodSource("rules")
    void move(Rule rule, Distance distance, Name name) {
        Car car = new Car(name);
        car.moveOrStop(rule);

        assertThat(car.getDistance()).isEqualTo(distance);
    }

    private static Stream<Arguments> rules() {
        Rule trueRule = () -> true;
        Rule falseRule = () -> false;
        return Stream.of(Arguments.of(trueRule, new Distance(MOVE_COUNT), new Name("name")),
                         Arguments.of(falseRule, new Distance(STOP_COUNT), new Name("name")));
    }

    @DisplayName("인자로 distance가 주어졌을 때 같은 거리를 움직였는지 검증")
    @ParameterizedTest
    @MethodSource("rules")
    void equalTest(Rule rule, Distance distance, Name name) {
        Car car = new Car(name);
        car.moveOrStop(rule);

        assertThat(car.isEqualDistance(distance)).isTrue();
    }
}
