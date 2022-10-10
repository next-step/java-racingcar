package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class CarTest {
    private static Car car;

    @BeforeEach
    void 셋업() {
        car = new Car("name");
    }

    @Test
    void create() {
        assertThat(new Car("ming", 1)).isEqualTo(new Car("ming", 1));
    }

    @Test
    void 이름() {
        assertThat(car.getName()).isEqualTo("name");
    }

    @Test
    void 이름_5자_초과하면_에러() {
        Throwable thrown = catchThrowable(() -> {car = new Car("sample_name");});
        assertThat(thrown).hasMessageContaining("최대 5글자까지 입력 가능합니다.");
    }

    @Test
    void 경주에_이기는지_확인() {
        assertThat(new Car("name1", 10).isWinner(new Car("name2", 1))).isEqualTo(true);
        assertThat(new Car("name1", 10).isWinner(new Car("name2", 10))).isEqualTo(true);
        assertThat(new Car("name1", 1).isWinner(new Car("name2", 10))).isEqualTo(false);
    }
}
