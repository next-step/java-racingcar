package study.step4.try2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesTest {

    @Test
    void 입력받은_자동차명이_유효한_값인지_확인하기() {
        String userInputCarNames = "pobi,javaj,igi";
        CarNames carName = new CarNames(userInputCarNames);
        assertThat(carName.valid(userInputCarNames)).isTrue();
    }

    @Test
    void 입력받은_자동차명을_콤마를_기준으로_자른_값을_가져오기() {
        CarNames carName = new CarNames("pobi,javaj,igi");
        assertThat(carName.getCarNames().length).isEqualTo(3);
    }
}
