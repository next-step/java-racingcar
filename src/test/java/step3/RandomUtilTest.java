//package step3;
//
//import org.junit.jupiter.api.Test;
//import step3.utils.NumberGenerator;
//import step3.utils.RandomUtil;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertAll;
//
//public class RandomUtilTest {
//    @Test
//    void getRandom() {
//        // given
//        NumberGenerator numberGenerator = new RandomUtil();
//
//        // when
//        int actual = numberGenerator.getRandom();
//
//        // then
//        assertAll(
//                () -> assertThat(actual).isGreaterThanOrEqualTo(0),
//                () -> assertThat(actual).isLessThanOrEqualTo(9)
//        );
//
//    }
//}
