package RacingGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Rule 적용시 Car의 위치가 알맞게 변경되는지 확인")
    public void RuleTest(){

        //given
        Car car = new Car();
        Rule rule = new DefaultRule();

        //when
        rule.playRule(car);

        //than
        assertThat(car.isAt()).isGreaterThan(-1);
        assertThat(car.isAt()).isLessThan(2);

    }

    @Test
    @DisplayName("game이 잘 진행되는지 확인")
    public void doRacingGame(){

        int numOfCar = 3;
        int numOfPlay = 5;

        RacingGame game = new RacingGame();
        game.prepareGame(numOfCar);
        game.playGameNumOfTry(numOfPlay);
    }

    @Test
    @DisplayName("Car의 name이 5글자 초과했을때 IllegalStateException 발생하는지 확인")
    public void carNameLengthOver5ThrowException(){
        assertThatIllegalStateException().isThrownBy(() ->{
            Car car = new Car("over5words");
        });

    }

    @Test
    @DisplayName("승자를 잘 가리는지 확인")
    public void winnerTest(){
        //given
        Car win = new Car("win");
       win.applyRule(11);

        Car lose = new Car("lose");
        lose.applyRule(3);

        //when
        RacingGame racingGame = new RacingGame();
        List<String> result = racingGame.getWinner(Arrays.asList(win, lose));

        //than
        assertThat(result.get(0)).isEqualTo("win");
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("승자가 두명일때 두명 가리는지 확인")
    public void twoWinnerTest(){
        //given
        Car win = new Car("win");
        win.applyRule(11);

        Car win2 = new Car("win2");
        win2.applyRule(11);

        Car lose = new Car("lose");
        lose.applyRule(5);

        //when
        RacingGame racingGame = new RacingGame();
        List<String> result = racingGame.getWinner(Arrays.asList(win, win2,lose));

        assertThat(result.size()).isEqualTo(2);
    }


        /*
    변경 전 테스트코드
     */

//    @Test
//    @DisplayName("Car가 자신이 존재한 위치를 잘 나타내는지 확인")
//    public void checkCarIsAt(){
//        Car racingCar = new Car();
//        for (int i = 0 ; i <5 ; i++){
//            racingCar.stopOrMove();
//        }
//
//        assertThat(racingCar.isAt()).isGreaterThan(-1);
//        assertThat(racingCar.isAt()).isLessThan(5);
//    }
//



}