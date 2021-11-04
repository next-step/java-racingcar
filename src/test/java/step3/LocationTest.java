package step3;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step3.Power.INSUFFICIENT;
import static step3.Power.SUFFICIENT;

class LocationTest {

    private static final int DEFAULT_LOCATION = 0;

    @Test
    void createWithNull() throws Exception {
        //given
        Integer location = null;

        //when
        ThrowingCallable createOn = () -> Location.createOn(location);

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(createOn)
                .withMessage("initialLocation is required");
    }

    @Test
    @DisplayName("출력이 충분하면 전진한다.")
    void goForwardTest1() throws Exception {
        //given
        Location location = createLocation();

        //when
        location.goForward(Power.SUFFICIENT);

        //then
        List<Integer> expectedTrace = Collections.singletonList(1);
        verifyTraceEquals(expectedTrace, location);
    }

    @Test
    @DisplayName("출력이 부족하면 전진하지 못한다.")
    void goForwardTest2() throws Exception {
        //given
        Location location = createLocation();

        //when
        location.goForward(INSUFFICIENT);

        //then
        List<Integer> expectedTrace = Collections.singletonList(0);
        verifyTraceEquals(expectedTrace, location);
    }

    @DisplayName("다양한 파라미터 테스트")
    @ParameterizedTest(name = "[{index}] powers: {0}, expectedTrace: {1}")
    @MethodSource("createVariousPowers")
    void goForwardTest3(List<Power> powers, List<Integer> expectedTrace) throws Exception {
        //given
        Location location = createLocation();

        //when
        powers.forEach(location::goForward);

        //then
        verifyTraceEquals(expectedTrace, location);
    }

    private static Stream<Arguments> createVariousPowers() {
        return Stream.of(
                Arguments.of(asList(INSUFFICIENT, INSUFFICIENT, SUFFICIENT), asList(0, 0, 1)),
                Arguments.of(asList(SUFFICIENT, SUFFICIENT, SUFFICIENT), asList(1, 2, 3)),
                Arguments.of(asList(INSUFFICIENT, INSUFFICIENT, INSUFFICIENT), asList(0, 0, 0)),
                Arguments.of(asList(INSUFFICIENT, SUFFICIENT, INSUFFICIENT), asList(0, 1, 1))
        );
    }

    private Location createLocation() {
        return Location.createOn(DEFAULT_LOCATION);
    }

    private void verifyTraceEquals(List<Integer> expectedTrace, Location location) {
        assertThat(location.readTrace()).isEqualTo(expectedTrace);
    }

}
