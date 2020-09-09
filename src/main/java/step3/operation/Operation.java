package step3.operation;

import step3.domain.Car;
import step3.utils.CarFactory;
import step3.utils.FindWinners;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;
import java.util.Random;

public class Operation {

    static ResultView resultView = new ResultView();

    public static void gameStart(int numOfAtp, int numOfCars) {
        resultView.viewProgress(numOfAtp, numOfCars);
    }

    public static void gameStartByName(int numOfAtp, String names) {
        List<Car> cars = CarFactory.create(names);
        InputView.inputTest(names, numOfAtp);

        for(int i = 0; i < numOfAtp; i++) {
            Operation.progressByName(cars);
        }
        FindWinners.findWinners(cars, numOfAtp);
    }

    public void progress(int[] game, int[] result) {
        for(int w = 0 ; w < game.length; w++) {
            game[w] = decideToMove(result[w], game[w]);
            resultView.showToMove(game[w]);
        }
    }

    public int decideToMove(int result, int game) {
        if(result >= 4) {
            return game + 1;
        }
        return game;
    }

    public int[] makeRandomValue(int numOfCars) {
        Random random = new Random();
        int[] randomValue = new int[numOfCars];
        for(int i = 0; i < randomValue.length; i++) {
            randomValue[i] = random.nextInt(10);
        }
        return randomValue;
    }

    public static void progressByName(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < cars.size(); j++) {
            int position = cars.get(j).getPosition() + process();
            cars.get(j).setPosition(position);
            sb.append(ResultView.progressView(cars.get(j)));
            sb.append(System.getProperty("line.separator"));
        }
        ResultView.view(sb.toString());
    }

    private static int process() {
        Random random = new Random();
        int randomNum = random.nextInt(10);
        if(randomNum >= 4) {
            return 1;
        }
        return 0;
    }

}
