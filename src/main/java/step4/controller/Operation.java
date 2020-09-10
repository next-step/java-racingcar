package step4.controller;

import step4.domain.Car;
import step4.utils.CarFactory;
import step4.utils.FindWinners;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;
import java.util.Random;

public class Operation {

    public static void gameStartByName(int numOfAtp, String names) {
        List<Car> cars = CarFactory.create(names);
        InputView.inputTest(names, numOfAtp);

        for(int i = 0; i < numOfAtp; i++) {
            Operation.progressByName(cars);
        }
        FindWinners.findWinners(cars, numOfAtp);
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
