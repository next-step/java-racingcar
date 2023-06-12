package edu.nextstep.camp.racing.domain;

import edu.nextstep.camp.testUtils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars cars;
    @BeforeEach
    void init(){
        cars = new Cars(List.of("TEST1", "TEST2")){
            @Override
            protected int randomInt(){
                return 4;
            }
        };
    }

    @Test
    void 자동차_움직임_랜덤값_삽입(){
        OutputStream outputStream = TestUtils.getOutputStream();
        cars.moveCars();

        assertThat(outputStream.toString())
                .isEqualTo("TEST1: -\nTEST2: -\n");
    }

    @Test
    void 우승자_테스트(){
        cars.moveCars();
        List<String> winners = cars.winners();

        assertThat(winners)
                .contains("TEST1", "TEST2");
    }

}
