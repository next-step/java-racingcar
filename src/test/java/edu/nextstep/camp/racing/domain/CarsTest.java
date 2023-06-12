package edu.nextstep.camp.racing.domain;

import edu.nextstep.camp.testUtils.TestUtils;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 자동차_움직임_랜덤값_삽입(){
        Cars cars = new Cars("TEST1", "TEST2"){
            @Override
            protected int randomInt(){
                return 4;
            }
        };

        OutputStream outputStream = TestUtils.getOutputStream();
        cars.moveCars();

        assertThat(outputStream.toString())
                .isEqualTo("TEST1: -\nTEST2: -\n");

    }
}
