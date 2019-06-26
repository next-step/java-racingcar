import domain.RacingGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RacingGameTest {
    int carPosition = 5;
    int maxPosition = 4;
    String namesOfCar = "a,b,c";
    int timeofGame = 10;

    @Test
    void checkNameOfCar() {
        String inputString = " ";
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    if (inputString.isEmpty() || inputString.equals(" ") || inputString.equals("\n"))
                        throw new IllegalArgumentException("입력값이 잘못되었습니다. 자동차 이름을 다시 한번 입력해주세요.");
                }
        );
    }

    @Test
    void splitName() {
        assertThat(namesOfCar.split(",")).containsExactly("a", "b", "c");
    }

    @Test
    void isRaceOnging() {
        int indexofTimeofGame = 6;

        assertThat(timeofGame > indexofTimeofGame).isTrue();
    }

    @Test
    public void getMaxPosition() {
        assertThat(Math.max(maxPosition, carPosition)).isEqualTo(5);
    }

    @Test
    void compareWithMaxPosition() {
        assertThat(carPosition == maxPosition).isFalse();
    }

}

