package racing.view;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {

    @Test
    void 숫자() {
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        assertThat(new UserInput().inputCntOfCar()).isEqualTo(3);
    }
}