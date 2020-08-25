package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Car;
import step4.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("Cars add test")
    public void addTest(){
        Cars cars = new Cars();
        cars.add(new Car("test"));
        cars.add(new Car("test2"));

        assertThat(cars.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Cars getMaxStatus test")
    public void test(){
        //given
        Cars cars = new Cars();

        Car car1 = new Car("car1");
        car1.run(4);
        car1.run(4);
        car1.run(3);

        Car car2 = new Car("car2");
        car2.run(0);
        car2.run(5);
        car2.run(0);

        Car car3 = new Car("car3");
        car3.run(6);
        car3.run(6);
        car3.run(6);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        //when
        //then
        assertThat(cars.getMaxStatus()).isEqualTo(3);
    }

    @Test
    @DisplayName("Cars print single Winner test")
    public void printSingleWinnertest(){
        //given
        Cars cars = new Cars();

        Car car1 = new Car("car1");
        car1.run(4);
        car1.run(4);
        car1.run(3);

        Car car2 = new Car("car2");
        car2.run(0);
        car2.run(5);
        car2.run(0);

        Car car3 = new Car("car3");
        car3.run(6);
        car3.run(6);
        car3.run(6);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        //when
        //then
        assertThat(cars.printWinner()).isEqualTo("car3");
    }

    @Test
    @DisplayName("Cars print multiple Winner test")
    public void printMultipleWinnertest(){
        //given
        Cars cars = new Cars();

        Car car1 = new Car("car1");
        car1.run(4);
        car1.run(4);
        car1.run(4);

        Car car2 = new Car("car2");
        car2.run(0);
        car2.run(5);
        car2.run(0);

        Car car3 = new Car("car3");
        car3.run(6);
        car3.run(6);
        car3.run(6);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        //when
        //then
        assertThat(cars.printWinner()).isEqualTo("car1,car3");
    }
}
