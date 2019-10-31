package step1.racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import step1.racing.view.CarPositionViewer;

class CarPositionViewerTest {
    @ParameterizedTest
    @MethodSource("carPositionsAndFlag")
    void rendering_test(List<Integer> carPositions, String flag) {
        CarPositionViewer.rendering(carPositions, flag);
    }

    private static Stream<Arguments> carPositionsAndFlag() {
        return Stream.of(
                Arguments.of(Arrays.asList(3, 4, 5), "&"),
                Arguments.of(Arrays.asList(3, 4, 5, 1, 2), "@")
        );
    }
}
