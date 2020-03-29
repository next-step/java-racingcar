package racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CarTest {

    @DisplayName("자동차 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "0:0",
            "1:0",
            "3:0",
            "4:1",
            "7:1",
            "9:1"}, delimiter = ':')
    void moveCar(int randNum, int expect) {
        //given
        Car car = new Car("car");

        //when
        car = car.moveCar(randNum);

        //then
        assertThat(car.getMoveRange()).isEqualTo(expect);
    }

    @DisplayName("자동차의 거리 이동 비교")
    @Test
    public void compareMoveRange() throws Exception {
        //given
        Car car = new Car("a", 1);

        //when
        int range = car.compareMoveRange(10);

        //then
        assertThat(range).isEqualTo(10);
    }

    @DisplayName("이동 거리를 비교하여 더 멀리 갔는지 비교 한다")
    @ParameterizedTest
    @CsvSource(value = {
            "1:false"
            , "5:false"
            , "9:false"
            , "10:true"
            , "15:true"}, delimiter = ':')
    public void howIsFar(int move, boolean expect) throws Exception {
        //given
        Car car = new Car("a", move);
        final int compare = 10;

        //when
        boolean movedFarThan = car.isMovedFarThan(compare);

        //then
        assertThat(movedFarThan).isEqualTo(expect);
    }
}
