package step5.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.strategy.CarsArrangeStrategy;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    Cars cars;
    @BeforeAll
    void createList(){
        cars = Cars.from(Arrays.asList(
                Car.of("a",1),
                Car.of("b",2),
                Car.of("c",3)));
    }

    @DisplayName("차량 댓수를 받아서 Cars 생성하기.")
    @Test
    void createCarsByCountsTest(){
        Cars cars = Cars.from(3);
        assertThat(cars.getSize()).isEqualTo(3);
    }

    @DisplayName("CarList 를 받아서 Cars 생성하기.")
    @Test
    void createCarsByListTest(){
        Cars cars = Cars.from(Arrays.asList(
                Car.from("a"),
                Car.from("b"),
                Car.from("c")));
        assertThat(cars.getSize()).isEqualTo(3);
    }

    @DisplayName("차 position 이 높은 순으로 정렬된 리스트 가져오기.")
    @Test
    void arrangeCarListByPositionTest(){
        assertThat(cars.arrangeList(new CarsArrangeStrategy())
                .stream().map(Car::getPosition)
                .collect(Collectors.toList())).containsExactly(3,2,1);
    }

    @DisplayName("차 이름문자열 배열 받아서 해당 이름으로 CarList 생성하기")
    @Test
    void moveCarsTest(){
        Cars cars = Cars.from(new String[]{"a","b","c"});
        assertThat(cars.getSize());
    }

}