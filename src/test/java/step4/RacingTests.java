package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTests {
    Car car;
    @BeforeEach
    public void before() {
        Car car = new Car();
    }

    @DisplayName("전진 잘 되는지 테스트")
    @Test
    public void test1() {
        assertThat(car.move(5)).isEqualTo(1);
    }

    @DisplayName("인자가 두개인 생성자 일 때 전진, 이름 출력 잘 되는지 확인")
    @Test
    public void test2() {

    }

}
