package step4.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void findWinner(){
        Car zorba = new Car("zorba");
        zorba.move(4);
        zorba.move(4);
        Car hbl = new Car("hbl");
        hbl.move(3);
        hbl.move(4);

        Cars cars =new Cars( Arrays.asList(zorba,hbl));
        Winners winners = cars.findWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners).contains(zorba);

    }

}
