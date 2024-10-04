import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Validator;

public class InputValidatorTest {
    @Test
    @DisplayName("자동차 갯수 체크 (1개 이상)")
    void checkNumberOfCarsTest() {
        //given
        final int numberOfCars = 1;

        //when
        boolean checked = Validator.isValidNumberOfCars(numberOfCars);

        //then
        Assertions.assertThat(checked).isTrue();
    }

    @Test
    @DisplayName("자동차 갯수 체크 (0개 이하)")
    void checkNumberOfCarsTest_LessThanZero() {
        //given
        final int numberOfCars = 0;

        //when
        boolean checked = Validator.isValidNumberOfCars(numberOfCars);

        //then
        Assertions.assertThat(checked).isFalse();
    }

    @Test
    @DisplayName("게임 횟수 체크 (1개 이상)")
    void checkNumberOfGamesTest() {
        //given
        final int numberOfGames = 1;

        //when
        boolean checked = Validator.isValidNumberOfGames(numberOfGames);

        //then
        Assertions.assertThat(checked).isTrue();
    }

    @Test
    @DisplayName("자동차 갯수 체크 (0개 이하)")
    void checkNumberOfGamesTest_LessThanZero() {
        //given
        final int numberOfGames = 0;

        //when
        boolean checked = Validator.isValidNumberOfCars(numberOfGames);

        //then
        Assertions.assertThat(checked).isFalse();
    }

    @Test
    @DisplayName("자동차 이름 길이 제한 체크 (5자 이하)")
    void checkLengthOfCarNameTest() {
        //given
        final String testCarName = "12345";
        //when
        boolean checked = Validator.isValidCarNameLength(testCarName);

        //then
        Assertions.assertThat(checked).isTrue();
    }

    @Test
    @DisplayName("자동차 이름 길이 제한 체크 (5자 이하)")
    void checkLengthOfCarNameTest_GraterThan5() {
        //given
        final String testCarName = "123456";
        //when
        boolean checked = Validator.isValidCarNameLength(testCarName);

        //then
        Assertions.assertThat(checked).isFalse();
    }
}
