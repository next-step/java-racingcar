package racingGame.racingGameException;

public class IllegalInputRange extends IllegalArgumentException {

    public IllegalInputRange(){
        super("벗어난 범위의 입력");
    }

}
