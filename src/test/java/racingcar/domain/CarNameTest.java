package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameTest {

    @Test
    void 자동차이름_유효성체크() throws Exception {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new CarName("aaaaaa"));
    }

}
