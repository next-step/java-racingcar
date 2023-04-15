//package step3;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//public class RacingCarFirstCollectionTest {
//    private final int TEST_POSITIVE_ONE = 1;
//    private final int TEST_NEGATIVE_ONE = -1;
//    private final int RANDOM_NUMBER_LIMIT = 4;
//    private Cars racingCar;
//
//    void init(int carCount, int period) {
//        this.racingCar = Cars.of(carCount, period);
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {1, 3, 5})
//    void 입력된_숫자만큼의_객체_생성(int count) {
//        init(count, TEST_POSITIVE_ONE);
//
//        Assertions.assertThat(racingCar.getSize()).isEqualTo(count);
//    }
//
//    @Test
//    void 음수입력시_예외처리() {
//        {
//            assertThatThrownBy(() -> init(TEST_NEGATIVE_ONE, TEST_POSITIVE_ONE)).isInstanceOf(RuntimeException.class).hasMessage("음수는 입력할 수 없습니다.");
//        }
//        {
//            assertThatThrownBy(() -> init(TEST_POSITIVE_ONE, TEST_NEGATIVE_ONE)).isInstanceOf(RuntimeException.class).hasMessage("음수는 입력할 수 없습니다.");
//        }
//    }
//
//    @Test
//    void 랜덤_생성_숫자가_4보다_큰지_작은지() {
//        init(TEST_POSITIVE_ONE, TEST_POSITIVE_ONE);
//        int randomNumber = racingCar.randomNumber();
//
//        if (randomNumber >= RANDOM_NUMBER_LIMIT) {
//            assertThat(randomNumber).isGreaterThanOrEqualTo(RANDOM_NUMBER_LIMIT);
//        } else {
//            assertThat(randomNumber).isLessThanOrEqualTo(RANDOM_NUMBER_LIMIT);
//        }
//
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {1, 3, 5})
//    void 입력_숫자만큼_라운드를_반복함(int round) {
//        init(TEST_POSITIVE_ONE, round);
//        int period = racingCar.iteratePeriod();
//        assertThat(period).isEqualTo(round);
//    }
//}
