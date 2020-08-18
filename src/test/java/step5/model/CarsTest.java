package step5.model;

import org.junit.jupiter.api.DisplayName;
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

        assertThat(winners.getWinner()).hasSize(1);
        assertThat(winners.getWinner()).contains(zorba);

    }

    @DisplayName("max 위치 찾기")
    @Test
    void getMaxPosition(){
        Car zorba = new Car("zorba");
        zorba.move(4);
        zorba.move(4);
        zorba.move(4);
        Car hbl = new Car("hbl");
        hbl.move(3);
        hbl.move(4);
        List<Car> carList = Arrays.asList(zorba,hbl);
        Cars cars = new Cars(carList);
        assertThat(cars.getMaxPosition()).isEqualTo(3);
    }

    @DisplayName("winner 찾기")
    @Test
    void filterWinners(){
        Car zorba = new Car("zorba");
        zorba.move(4);
        zorba.move(4);
        zorba.move(4);
        Car hbl = new Car("hbl");
        hbl.move(5);
        hbl.move(5);
        hbl.move(5);
        Car other =new Car("other");
        other.move(3);
        List<Car> carList = Arrays.asList(zorba,hbl,other);
        Cars cars = new Cars(carList);

        assertThat(cars.filterWinners(3)).hasSize(2);


    }
}
