package step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.catchThrowable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class RacingGameTest {

    RacingGame racingGame;

    @BeforeEach
    public void before() {
        racingGame = new RacingGame();
    }

    private static Stream<Arguments> provideCarNamesTestCase() {
        return Stream.of(
            Arguments.of("a", IllegalArgumentException.class),
            Arguments.of("a,a", IllegalArgumentException.class),
            Arguments.of("a,b,c,c", IllegalArgumentException.class),
            Arguments.of("a,b,c,d", null),
            Arguments.of("a,b", null)
        );
    }

    @ParameterizedTest
    @MethodSource({"provideCarNamesTestCase"})
    void validateCarNames(String input, Class exception) {

        //when
        Throwable thrown = catchThrowable(() -> racingGame.validateCarNames(input));

        //then
        if (exception != null) {
            assertThat(thrown).isInstanceOf(exception);
        }
        if (exception == null) {
            assertThat(thrown).isNull();
        }
    }

    @ParameterizedTest
    @CsvSource({"1,true","2,true","3,true","9,true","10,true","11,false","-1,false","0,false"})
    void validateTryCount(String input, String expected) {
        //when
        Throwable thrown = catchThrowable(() -> racingGame.validateTryCount(Integer.valueOf(input)));

        //then
        if (false == Boolean.valueOf(expected)) {
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        }
        if (true == Boolean.valueOf(expected)) {
            assertThat(thrown).isNull();
        }
    }

    private static Stream<Arguments> provideDuplicateCarNames() {
        return Stream.of(
            Arguments.of(new String[]{"a","a"}, false),
            Arguments.of(new String[]{"a","b","c","d","d"}, false),
            Arguments.of(new String[]{"a"}, true),
            Arguments.of(new String[]{"a","b","c","d","e"}, true)
            );
    }

    @ParameterizedTest
    @MethodSource("provideDuplicateCarNames")
    void validateDuplicatedCarNames(String[] input, Boolean expected) {
        //when
        Throwable thrown = catchThrowable(() -> racingGame.validateDuplicatedCarNames(input));

        //then
        if (expected == false ) {
            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.DUPLICATED_CAR_NAMES_MESSAGE);
        }

        if (expected == true) {
            assertThat(thrown).isNull();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"a,b,c/3","a,b.c/2", "a/1"}, delimiter = '/')
    void parseCarNames(String input, int size) {
        assertThat(racingGame.parseCarNames(input)).hasSize(size);
    }

    @Test
    @DisplayName("설정한 값의 초기화가 잘되었는지 테스트")
    void initialize() {
        //given
        String names = "a,b,c,d";
        int tryCount = 5;

        racingGame.initialize(names, tryCount);

        assertThat(racingGame.getNames()).containsExactly("a","b","c","d");
        assertThat(racingGame.getNames()).hasSize(4);
        assertThat(racingGame.getTryCount()).isEqualTo(tryCount);
        assertThat(racingGame.getCarPositions()).hasSize(4);
        assertThat(racingGame.getCarPositions()).containsOnly(0);
    }

    @Test
    void goCar() {
        //given
        racingGame.initialize("a,b,c",3);
        Random random = mock(Random.class);
        racingGame.setRandom(random);
        when(random.nextInt())
            .thenReturn(5);

        //when
        racingGame.goCar();

        //then
        assertThat(racingGame.getCarPositions()).containsOnly(1);
    }
}