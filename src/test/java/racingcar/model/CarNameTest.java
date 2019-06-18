package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {
    @Test
    void CarName은_캐시를_이용한다() {
        String nameBase = "yong";
        CarName name1 = CarName.valueOf(nameBase);
        CarName name2 = CarName.valueOf(nameBase);

        assertThat(name1 == name2).isTrue();
    }

    @Test
    void CarName은_이름이_같으면_같은_객체다() {
        String nameBase = "yong";
        CarName name1 = CarName.valueOf(nameBase);
        CarName name2 = CarName.valueOf(nameBase);

        assertThat(name1.equals(name2)).isTrue();
    }
}