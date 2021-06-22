package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    private String name = "a,b,c";
    private String winner = "b";

    @DisplayName("Cars의 객체를 생성한다.")
    @Test
    public void carsTest(){
        Cars cars = new Cars(name.split(","));
        assertThat(cars).isInstanceOf(Cars.class);
    }

    @DisplayName("우승자를 선별한다.")
    @Test
    public void selectWinnersTest(){
        Cars cars = new Cars(name.split(","));

        cars.getCars().get(0).move(true);
        cars.getCars().get(1).move(true);
        cars.getCars().get(1).move(true);

        List<Car> actualWinners = cars.selectWinners();
        assertThat(actualWinners.get(0).getName()).isEqualTo(winner);
    }
}
