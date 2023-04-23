package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingInformationTest {

    @Test
    @DisplayName("레이싱카 생성 테스트")
    void 레이싱카_생성_테스트() {
        String given = "안녕하세요,반갑습니다";
        RacingInformation racingInformation = RacingInformation.of(given, 5);

        assertAll(
                () -> assertThat(racingInformation.getRacingCarGroup().getRacingCarList().stream().map(RacingCar::getName)).containsExactly("안녕하세요", "반갑습니다"),
                () -> assertThat(racingInformation.getReps().getReps()).isEqualTo(5)
        );
    }


    @ParameterizedTest
    @ValueSource(strings = {",,,,,",",", ",,"})
    @DisplayName("콤마(,)만 있을 때 에러를 던진다")
    void 콤마_만_있을_때_에러를_던진다(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> RacingInformation.of(input, 5))
                .withMessage("자동차 이름을 입력해주세요");

    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null or 빈값 일 경우 예외를 던진다")
    void null_or_빈값_일_경우_예외를_던진다(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> RacingInformation.of(input, 5))
                .withMessage("자동차 이름을 입력해주세요");

    }

    @Test
    @DisplayName("같은 이름이 있을 때 에러를 던진다")
    void 같은_이름이_있을_때_에러를_던진다() {
        String carNames = "pobi1,pobi1,pobi3";

        assertThatIllegalArgumentException().isThrownBy(() -> RacingInformation.of(carNames, 5))
                .withMessage("같은 이름이 있습니다");
    }

    @Test
    @DisplayName("우승 자동차 위치 구하기 테스트")
    void 우승_자동차_위치_구하기_테스트() {
        String given = "안녕하세요,반갑습니다";

        RacingInformation racingInformation = RacingInformation.of(given, 5);
        racingInformation.getRacingCarGroup().getRacingCarList().get(0).move(()->true);

        assertThat(racingInformation.getRacingCarGroup().getWinnerLocation()).isEqualTo(1);
    }


    @Test
    @DisplayName("단독 1등 우승자 구하기 테스트")
    void 단독_1등_우승자_구하기_테스트() {
        String given = "안녕하세요,반갑습니다,포포로로";

        RacingInformation racingInformation = RacingInformation.of(given, 5);
        racingInformation.getRacingCarGroup().getRacingCarList().get(0).move(()->true);

        assertThat(racingInformation.getRacingCarGroup().getWinnerName()).containsExactly("안녕하세요");
    }

    @Test
    @DisplayName("공동 우승자 구하기 테스트")
    void 공동_우승자_구하기_테스트() {
        String given = "안녕하세요,반갑습니다,포포로로";

        RacingInformation racingInformation = RacingInformation.of(given, 5);
        racingInformation.getRacingCarGroup().getRacingCarList().get(0).move(()->true);
        racingInformation.getRacingCarGroup().getRacingCarList().get(1).move(()->true);

        assertThat(racingInformation.getRacingCarGroup().getWinnerName()).containsExactly("안녕하세요","반갑습니다");
    }


    @Test
    @DisplayName("레이싱카 목록을 임의로 조장시 예외를 던진다.")
    void test(){
        String given = "안녕하세요,반갑습니다,포포로로";
        RacingInformation racingInformation = RacingInformation.of(given, 5);

        assertThatThrownBy(() ->  racingInformation.getRacingCarGroup().getRacingCarList().clear())
                .isInstanceOf(UnsupportedOperationException.class);

    }
}