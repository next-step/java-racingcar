package step4.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    void create(){
        Winners winners = new Winners(Arrays.asList(
                new Car("zorba"), new Car("lhb")
        ));

        assertThat(winners.createWinnerNames()).isEqualTo("zorba,lhb");
    }
}
