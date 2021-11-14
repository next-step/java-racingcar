package study.racing;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import study.racing.model.car.Car;
import study.racing.model.rule.Rule;

public class CarTest {

    @DisplayName("Rule에 따라 움직이는지 멈추는지 동작을 검증")
    @ParameterizedTest
    @MethodSource("rules")
    void move(Rule rule, int distance) {
        Car car = new Car();
        car.moveOrStop(rule);
        assertThat(car.getDistance()).isEqualTo(distance);
    }

    private static Stream<Arguments> rules() {
        int moveCount = 1;
        int stopCount = 0;
        Rule trueRule = new Rule() {
            @Override
            public boolean isFollowRule() {
                return true;
            }
        };
        Rule falseRule = new Rule() {
            @Override
            public boolean isFollowRule() {
                return false;
            }
        };
        return Stream.of(Arguments.of(trueRule, moveCount), Arguments.of(falseRule, stopCount));
    }
}
