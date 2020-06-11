package step2;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class InputProvider extends Provider{

    private static Stream<Arguments> provideSimpleEquation() {
        return convertArrayToStream(new String[]{
                "1 + 1, 2",
                "1 - 1, 0",
                "1 * 1, 1",
                "1 / 1, 1",
        });
    }

    private static Stream<Arguments> provideComplexEquation() {
        return convertArrayToStream(new String[]{
                "1 + 1 * 4, 8",
                "2 - 1 / 2, 0.5",
                "1 * 1 + 5, 6",
                "1 / 1 - 4, -3"
        });
    }
}
