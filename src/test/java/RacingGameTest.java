import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RacingGameTest {
    int carPosition = 5;
    int maxPosition = 4;

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
        String names = "a,b,c";
        assertThat(names.split(",")).containsExactly("a", "b", "c");
    }

    @Test
    void isEnd() {
        int timeOfGame = 5;
        int indexofTimeofGame = 6;

        assertThat(timeOfGame < indexofTimeofGame).isTrue();
    }

    @Test
    public void getMaxPosition() {
        int maxPosition = 4;
        assertThat(Math.max(maxPosition, this.carPosition)).isEqualTo(5);
    }

    @Test
    void compareWithMaxPosition() {
        assertThat(this.carPosition == this.maxPosition).isFalse();
    }

    @Test
    void makeStatusofCar() {
        StringBuilder status = new StringBuilder();
        String carStatus;

        for (int i = 0; i < this.carPosition; ++i) {
            status.append("-");
        }
        carStatus = status.toString();
        assertThat(carStatus).isEqualTo("-----");
    }

}

