package step3.model.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.domain.car.Car;
import step3.domain.car.Location;
import step3.domain.oil.OilTank;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static step3.domain.oil.Oil.BAD;
import static step3.domain.oil.Oil.GOOD;

class CarTest {

    private static final int DEFAULT_LOCATION = 0;

    @Test
    void accelerateWithEmptyOilTank() throws Exception {
        //given
        OilTank emptyOilTank = OilTank.fill(emptyList());
        Car car = new Car(emptyOilTank, createLocation());

        //when
        car.fullAccelerate();

        //then
        verifyTraceEquals(car, emptyList());
    }

    @ParameterizedTest(name = "[{index}] oilTank: {0}, expectedTrace: {1}")
    @MethodSource("createVariousOilTankAndTrace")
    void accelerateWithEmptyOilTank(OilTank oilTank, List<Integer> expectedTrace) throws Exception {
        //given
        Car car = new Car(oilTank, createLocation());

        //when
        car.fullAccelerate();

        //then
        verifyTraceEquals(car, expectedTrace);
    }

    private Location createLocation() {
        return Location.createOn(DEFAULT_LOCATION);
    }

    private void verifyTraceEquals(Car car, List<Integer> expectedTrace) {
        assertThat(car.readTrace()).isEqualTo(expectedTrace);
    }

    private static Stream<Arguments> createVariousOilTankAndTrace() {
        return Stream.of(
                Arguments.of(OilTank.fill(asList(GOOD, BAD, GOOD)), asList(1, 1, 2)),
                Arguments.of(OilTank.fill(asList(GOOD, GOOD, GOOD)), asList(1, 2, 3)),
                Arguments.of(OilTank.fill(asList(BAD, GOOD, BAD)), asList(0, 1, 1)),
                Arguments.of(OilTank.fill(asList(BAD, BAD, BAD)), asList(0, 0, 0)),
                Arguments.of(OilTank.fill(asList(GOOD, BAD, BAD)), asList(0, 0, 1))
        );
    }

}
