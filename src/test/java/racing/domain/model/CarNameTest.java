package racing.domain.model;

import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    void CarName_5글자이상_생성_test()
    {
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarName.of("abcdefgh"));
    }

    @Test
    void CarName_빈값_생성_test()
    {
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarName.of(""));
    }

    @Test
    void CarName_null_생성_test()
    {
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarName.of(null));
    }
}