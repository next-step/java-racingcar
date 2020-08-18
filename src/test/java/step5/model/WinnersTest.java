package step5.model;

import org.junit.jupiter.api.Test;
import step5.utility.ResultView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    void createWinnerNames(){
        List<Car> carList =  Arrays.asList(
                new Car("zorba"), new Car("lhb"));

        assertThat(ResultView.createWinnerNames(carList)).isEqualTo("zorba,lhb");
    }
}
