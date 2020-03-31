package racinggame.domain.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.car.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingRoundResultsTest {


    private RacingCars cars1;
    private RacingCars cars2;
    private RacingCars addCars;

    @BeforeEach
    void setUp() {
        cars1 = new RacingCars(
                Arrays.asList(new Car("a"), new Car("b")));
        cars2 = new RacingCars(
                Arrays.asList(new Car("c"), new Car("d")));
        addCars = new RacingCars(
                Arrays.asList(new Car("1"), new Car("2")));
    }

    @DisplayName("getResults()로 반환된 List는 수정 가능 해야 한다.")
    @Test
    public void getResults_success_addElement() throws Exception {
        //given
        RacingRoundResults result = new RacingRoundResults();
        result.addResult(cars1);

        //when
        List<RacingCars> modify = result.getResults();

        //then
        assertThat(modify.add(addCars)).isTrue();
    }

    @DisplayName("외부로 전달된 값이 변화되어도 도메인에는 영항이 없어야 한다")
    @Test
    public void getResults_fail_modify() throws Exception {
        //given
        RacingRoundResults result = new RacingRoundResults();
        result.addResult(cars1);

        //when
        List<RacingCars> modify = result.getResults();
        modify.add(addCars);

        //then
        assertAll(
                () -> assertThat(result.getResults().size()).isEqualTo(0),
                () -> assertThat(modify.size()).isEqualTo(1)
        );
    }
}
