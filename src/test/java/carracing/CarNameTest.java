package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNameTest {
    @Test
    @DisplayName("CarName이 constructor로 제공한 이름을 getName을 통해 반환하는지 확인한다.")
    void carName() {
        CarName carName = new CarName("name");
        assertThat(carName.getName()).isEqualTo("name");
    }

    @Test
    @DisplayName("5자를 넘기는 이름을 constructor로 제공할때 IllegalArgumentException이 발생한다.")
    void nameLengthException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarName("longname");
        });
    }

    @Test
    @DisplayName("다른 객체더라도 동일한 이름을 가지면 equals가 true를 반환한다.")
    void equals() {
        assertThat(new CarName("name")).isEqualTo(new CarName("name"));
    }
}