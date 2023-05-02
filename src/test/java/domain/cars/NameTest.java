package domain.cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @DisplayName("입력받은 이름에 대해 차를 생성하고 이름을 부여할 수 있다.")
    @Test
    public void shouldNameAndCreateCar_whenInputName() throws Exception {
        //given
        String name = "name";
        //when
        RacingCar car = new RacingCar(name);
        //then
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    public void nameShouldNotExceedFiveWords() {
        //given
        String exampleName = "sixxxX";

        //when
        assertThatThrownBy(() -> {
            Name name = new Name(exampleName);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
