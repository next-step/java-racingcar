package step03.calculatescore;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:48 오전
 */
public class CalculatorRandomScore implements ScoreCalculate{

    @Override
    public int calculateScore() {
        return (int)((Math.random()*10000)%10);
    }
}
