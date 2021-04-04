package RacingGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

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

        RacingGame racingGame = new RacingGame();
        String[] nameOfCars = new String[]{"yurim","some","hey"};

        racingGame.getInputValue(nameOfCars);
        racingGame.prepareGame();
        List<Car> cars = racingGame.playGame();

        Assertions.assertThat(cars.size()).isEqualTo(3);

    }

    @Test
    @DisplayName("Car의 name이 5글자 초과했을때 IllegalStateException 발생하는지 확인")
    public void carNameLengthOver5ThrowException(){
        assertThatIllegalStateException().isThrownBy(() ->{
            Car car = new Car("over5words");
        });

    }

    @Test
    @DisplayName("공백인 문자열에 대해 오류 처리")
    public void emptyNameThrowsException(){
        assertThatIllegalStateException().isThrownBy(() ->{
            Car car = new Car("  ");
        });
    }

    @Test
    @DisplayName("가장 멀리간 maxLocation을 잘 구하는지 확인")
    public void maxLocation(){
        //given
        Car win = new Car("win");
        win.applyRule(11);

        Car lose = new Car("lose");
        lose.applyRule(3);

        //when
        RacingGame racingGame = new RacingGame();
        Integer maxLocation = racingGame.getMaxLocation(Arrays.asList(win, lose));

        //than
        assertThat(maxLocation).isEqualTo(11);

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
        List<Car> racingCars = Arrays.asList(win,lose);
        Integer maxLocation = racingGame.getMaxLocation(racingCars);
        List<String> result = racingGame.namesOfWinner(maxLocation,racingCars);


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
        List<Car> racingCars = Arrays.asList(win,win2,lose);
        Integer maxLocation = racingGame.getMaxLocation(racingCars);
        List<String> result = racingGame.namesOfWinner(maxLocation,racingCars);

        assertThat(result.size()).isEqualTo(2);
    }



}