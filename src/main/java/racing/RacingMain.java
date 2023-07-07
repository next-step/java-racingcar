package racing;


import racing.controller.RacingApplication;
import racing.exception.RacingBaseException;
import racing.generator.RandomNumberGenerator;
import racing.controller.input.RacingInput;

public class RacingMain {
    public static void main(String[] args) {
        try {
            new RacingApplication(new RacingInput(System.in), new RandomNumberGenerator()).run();
        } catch (RacingBaseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
