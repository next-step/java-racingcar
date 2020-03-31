package racinggame.domain.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.car.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

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

    @DisplayName("getResults()로 반환된 List는 수정 불가능 해야 한다. : addResult() 이용했을때")
    @Test
    public void getResults_fail_addResult() throws Exception {
        //given
        RacingRoundResults result = new RacingRoundResults();
        result.addResult(cars1);

        //when
        List<RacingCars> modify = result.getResults();

        //then
        assertThatThrownBy(
                () -> assertThat(modify.add(addCars))
        ).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("getResults()로 반환된 List는 수정 불가능 해야 한다. : 생성자에서 이미 초기화 했을때")
    @Test
    public void getResults_fail_constructUseList() throws Exception {
        //given
        List<RacingCars> racingCars = new ArrayList<>(Arrays.asList(cars1, cars2));
        RacingRoundResults results = new RacingRoundResults(racingCars);

        //when
        List<RacingCars> modify = results.getResults();

        //then
        assertThatThrownBy(
                () -> assertThat(modify.add(addCars))
        ).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("getResults()로 반환된 List는 수정 불가능 해야 한다. : 생성자에서 이미 초기화 했을때")
    @Test
    public void getResults_fail_constructUseOne() throws Exception {
        //given
        RacingRoundResults results = new RacingRoundResults(cars1);

        //when
        List<RacingCars> modify = results.getResults();

        //then
        assertThatThrownBy(
                () -> assertThat(modify.add(addCars))
        ).isInstanceOf(UnsupportedOperationException.class);
    }
}
