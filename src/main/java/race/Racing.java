package race;

import java.util.List;

public class Racing {

    private static int carCount;
    private static int tryCount;
    private static List<Integer> carList;

    public static void main(String[] args) {
        carCount = RacingController.setCarCount();
        tryCount = RacingController.setTryCount();
        carList = RacingController.setCarList(carCount);

        RacingController.racing(tryCount, carList);
    }
}
