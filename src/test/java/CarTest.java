import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car");
    }

    @Test
    public void 자동차_전진여부논리값이true라면위치는변한다() {
        int beforePosition = car.getPosition();
        car.move(() -> true);
        int afterPosition = car.getPosition();

        assertThat(afterPosition).isEqualTo(beforePosition + 1);
    }

    @Test
    public void 자동차_전진여부논리값이false라면위치는변하지않는다() {
        int beforePosition = car.getPosition();
        car.move(() -> false);
        int afterPosition = car.getPosition();

        assertThat(beforePosition).isEqualTo(afterPosition);
    }

    @Test
    public void 자동차이름은_5자를_초과할수없다() {
        String name = "abcdef";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }
}