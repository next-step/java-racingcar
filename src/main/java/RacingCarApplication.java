import java.util.List;
import view.InputView;

public class RacingCarApplication {

    private final static int NUMBER_OR_CAR_INDEX = 0;
    private final static int COUNT_OF_TRIAL = 1;

    public static void main(String[] args) {
        List<Integer> integers = InputView.requestInput();
        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }
    }
}
