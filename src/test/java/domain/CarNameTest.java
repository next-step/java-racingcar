package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    void carName이_비어있는경우() {
        CarName carName = new CarName("");
        assertThat(carName.name()).isEqualTo("NoName");
    }

    @Test
    void carName이_5글자_이하인경우() {
        CarName carName = new CarName("abcde");
        assertThat(carName.name()).isEqualTo("abcde");
    }

    @Test
    void carName이_5글자_초과인경우() {
        CarName carName = new CarName("abcdef");
        assertThat(carName.name()).isEqualTo("abcde");
    }

}
