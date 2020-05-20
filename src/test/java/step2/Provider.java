package step2;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

public abstract class Provider {

    public static Stream<Arguments> convertArrayToStream(String[] argumentArray) {
        return Arrays.stream(argumentArray)
                .map(argument -> argument.split(","))
                .map(argument -> createArgument(argument));
    }

    private static Arguments createArgument(String... input) {
        return Arguments.of(input);
    }
}
