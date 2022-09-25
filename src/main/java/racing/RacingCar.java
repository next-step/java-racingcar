package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    public static void racing() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.input();
        resultView.printTitle();

        List positions = getPositions(inputView.getCars());

        for(int i=0 ; i< inputView.getTimes() ; i++) {
            getResult(positions, resultView);
            resultView.printBlank();
        }
    }

    private static void getResult(List positions, ResultView resultView){
        for(int j = 0; j < positions.size() ; j++) {
            int position = plusCount((int)positions.get(j), getRandomNum());
            positions.set(j, position);
            resultView.printResult(position);
        }
    }

    private static List getPositions(int cars) {
        List positions = new ArrayList();
        for(int i = 0; i < cars; i++) {
            positions.add(0);
        }
        return positions;
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
