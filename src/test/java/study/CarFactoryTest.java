package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
        carFactory = CarFactory.getInstance();
    }


    @Test
    @DisplayName("이름이 담긴 List 를 통하여 이름이 담긴 자동차를 list의 개수 만큼 생성한다. ")
    void createCar() {
        //given
        List<String> nameList = new ArrayList<>() {{
            add("최태훈");
            add("조아영");
            add("김정환");
        }};

        List<RacingCar> racingCarList = carFactory.createCar(nameList);

        assertThat(racingCarList.size()).isEqualTo(3);
        assertThat(racingCarList).contains(new RacingCar("최태훈"),new RacingCar("조아영"),new RacingCar("김정환"));

    }
}