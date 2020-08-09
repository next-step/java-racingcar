package racingcar;

import java.util.Random;

public class RacingGame {
    private static final int MAX_LANDOM_NUMBER = 10;

    public static void execute(){
        int count = InputView.getCountOfCar();
        int repeat = InputView.getCountOfRepeat();

        Cars cars = new Cars(count);
        System.out.println(ResultView.startResultMessage());

        for(int i = 0; i < repeat; i++){
            cars.moveCars();
            ResultView.drawResult(cars);
        }
    }

    //랜덤 값 나오는 메서드
    public static int randomNumber(){
        Random random = new Random();
        return random.nextInt(MAX_LANDOM_NUMBER);
    }
}
