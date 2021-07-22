package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GamePlayTest {

    private GamePlay gamePlay;

    @BeforeEach
    void setup() {
        gamePlay = new GamePlay();
    }

    @Test
    @DisplayName("자동차는 입력값의 , 에따라 생성된다.")
    public void createPayerBySplit() {
        List<Player> playerList1 = gamePlay.createPlayer("car1,car2,car3");

        assertThat(playerList1.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차는 입력된 배열에 따라 생성된다.")
    public void setupPayerByArray() {
        String[] array = gamePlay.stringToStringArray("car1,car2,car3");
        List<Player> playerList1 = gamePlay.setupPlayer(array);

        assertThat(playerList1.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차의 이름은 5글자를 초과하면 예외가 발생된다.")
    public void createPayerNameLimit_check() {
        assertThatThrownBy(() -> gamePlay.createPlayer("naming,para,you"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자를 초과할수 없습니다.");
    }

    @Test
    @DisplayName("자동차는 최소 1대이상 아니면 예외가 발생된다.")
    public void createPayerAtListOne_check() {
        assertThatThrownBy(() -> gamePlay.createPlayer(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 최소 1대 이상이어야 한다.");
    }

    @Test
    @DisplayName("입력값의 , 따라 배열로 변환된다.")
    public void stringBySplit() {
        String[] resultArray = gamePlay.stringToStringArray("a,b,c");

        assertThat(resultArray.length).isEqualTo(3);
        assertThat(resultArray[0]).isEqualTo("a");
    }

    @Test
    @DisplayName("여러공백이 들어가도 공백은 합쳐진다.")
    public void stringByTrim() {
        String result = gamePlay.stringByTrim("12      ");
        System.out.println(result);
        assertThat(result).isEqualTo("12");
    }

    @Test
    @DisplayName("랜덤함수는 0~9사이의 값을 가지고 있다.")
    public void randomValue_check() {
        int firstValue = 0;
        int lastValue = 10;

        int result1 = gamePlay.randomValue();

        betweenCheck(result1, firstValue, lastValue);

        int result2 = gamePlay.randomValue();


        betweenCheck(result2, firstValue, lastValue);
    }

    private void betweenCheck(int checkValue, int firstValue, int lastValue) {
        assertThat(checkValue).isGreaterThan(firstValue).isLessThan(lastValue);
    }

}
