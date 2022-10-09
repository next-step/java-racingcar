package step3.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Cars;
import step3.domain.Winner;
import step3.util.Separation;

import static org.assertj.core.api.Assertions.assertThat;

class SeparationTest {

    private Separation separation = new Separation();
    private String input = "pobi,crong,honux";

    @Test
    @DisplayName("입력받은 문자열을 구분자로 구분해서 반환하는 테스트")
    void nameSeparationTest() {
        Separation separation = new Separation();
        assertThat(separation.nameSeparation(input).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자를 구분자로 구분해서 반환하는 테스트")
    void winnerSeparationTest() {
        Winner winner = new Winner(new Cars(separation.nameSeparation(input)).getCarList());
        assertThat(separation.winnerSeparation(winner)).isEqualTo(input);
    }

}