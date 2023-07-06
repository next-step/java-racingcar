package racing;


import racing.generator.RandomNumberGenerator;
import racing.input.RacingInput;

public class RacingMain {
    public static void main(String[] args) {
        new RacingExceptionHandler(new RacingApplication(new RacingInput(System.in), new RandomNumberGenerator())).exceptionHandle();
    }
}
