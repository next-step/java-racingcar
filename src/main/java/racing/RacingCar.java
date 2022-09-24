package racing;

import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    private static Scanner scanner = new Scanner(System.in);
    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();
    private static int[] position;

    public static void racing() {
        inputView.input(scanner);

        position = new int[inputView.getCars()];

        resultView.printTitle();

        for(int i=0 ; i< inputView.getTimes() ; i++) {
            getResult(inputView.getCars());
            resultView.printBlank();
        }
    }

    private static void getResult(int cars) {
        for(int j = 0; j < cars ; j++) {
            position[j] = plusCount(position[j], getRandomNum());
            resultView.printResult(position[j]);
        }
    }

    public static int plusCount(int count, int number) {
        if(isFourOrMore(number)) {
            return count+1;
        }
        return count;
    }

    public static int getRandomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static boolean isFourOrMore(int number) {
        if (number >= 4 ) {
            return true;
        }
        return false;
    }
}
