package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final boolean GO = true;
    private static final boolean STOP = false;
    private static boolean READY = true;

    public static void main(String[] args) {
        int countOfCars = InputView.inputCountofCars();
        int tryCount = InputView.inputTryCount();

        List<RacingCar> carList = new ArrayList<>();
        while (countOfCars-- > 0) {
            carList.add(new RacingCar());
        }

        System.out.println("실행 결과");
        while (tryCount-- > 0) {
            racing(carList);
            ResultView.printRacingResult(carList);
            System.out.println();
            READY = false;
        }
    }

    private static void racing(List<RacingCar> carList) {
        for (int i = 0; i < carList.size(); i++) {
            if(!READY && goAndStop()) {
                carList.get(i).route.append("-");
            }
        }
    }

    public static boolean goAndStop() {
        Random random = new Random();
        if(random.nextInt(10) >= 4) {
            return GO;
        }
        return STOP;
    }
}
