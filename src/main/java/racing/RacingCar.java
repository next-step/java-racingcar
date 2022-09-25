package racing;

import java.util.Random;

public class RacingCar {

    public static void racing() {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.input();

        resultView.printTitle();

        for(int i=0 ; i< inputView.getTimes() ; i++) {
            getResult(inputView.getCars(), inputView.getCars(), resultView);
            resultView.printBlank();
        }
    }

    private static void getResult(int cars, int carsNumber, ResultView resultView) {
        int[] position = new int[carsNumber];

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
