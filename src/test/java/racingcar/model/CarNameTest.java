package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {
    private String name;

    @BeforeEach
    void setUp() {
        this.name = "yong";
    }

    @Test
    void CarName은_캐시를_이용한다() {
        CarName name1 = CarName.valueOf(name);
        CarName name2 = CarName.valueOf(name);

        assertThat(name1 == name2).isTrue();
    }

    @Test
    void CarName은_이름이_같으면_같은_객체다() {
        CarName name1 = CarName.valueOf(name);
        CarName name2 = CarName.valueOf(name);

        assertThat(name1.equals(name2)).isTrue();
    }
}