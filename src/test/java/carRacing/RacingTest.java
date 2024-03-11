package carRacing;

import carRacing.view.InputView;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    void resultView_Test(){

    }

    @Test
    void inputView_Test(){

        InputView inputView = new InputView();
        assertThat(inputView.getCarCount()).isEqualTo(3);
        assertThat(inputView.getMoveCount()).isEqualTo(5);
    }


    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }

}
