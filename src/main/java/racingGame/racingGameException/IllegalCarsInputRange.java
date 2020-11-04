package racingGame.racingGameException;

public class IllegalCarsInputRange extends IllegalArgumentException {

    public IllegalCarsInputRange(){
        super("1보다 작은 입력값");
    }

}
