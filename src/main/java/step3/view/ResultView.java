package step3.view;

import step3.domain.Car;
import step3.domain.RacingCar;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultView {

    private static final String GAME_RESULT = "게임 결과";
    private static final String PRINT_WINNER_TEXT = "가 최종 우승했습니다.";
    public static String ACCELATE_SIGN = "-";
    public static String BRAKE_SIGN = "";

    public static void gameResult() {
        System.out.println(GAME_RESULT);
    }

    public static void carRace(Map<String, Car> carInfoMap, int gameCount) {
        for (int i = 1; i <= gameCount; i++) {
            participatingCars(carInfoMap);
        }
    }

    public static void participatingCars(Map<String, Car> carInfoMap) {
        Set<String> keys = carInfoMap.keySet();
        for (String carName : keys) {
            Car car = carInfoMap.get(carName);
            int carPosition = car.getPosition();

            boolean raceResult = RacingCar.isRaceStart(carInfoMap, car.getCarName());
            carPosition += RacingCar.updatePosition(raceResult);
            String mileAge = printMovement(carPosition);

            car = new RacingCar(car.getCarName(), carPosition);
            carInfoMap.put(car.getCarName(), car);

            System.out.println(car.getCarName() + " : " + mileAge);
        }
        System.out.println();
    }


    public static String printMovement(int position) {
        String mileAge = "";
        for (int i = 0; i < position; i++) {
            mileAge += ACCELATE_SIGN;
        }
        return mileAge;
    }

    public static String printWinner(List<String> winners) {
        StringBuffer winnerMember = new StringBuffer();
        Iterator<String> iterator = winners.iterator();

        while (iterator.hasNext()) {
            winnerMember.append(iterator.next());
            findNextValue(iterator, winnerMember);
        }
        winnerMember.append(PRINT_WINNER_TEXT);
        return winnerMember.toString();
    }

    public static StringBuffer findNextValue(Iterator<String> iterator, StringBuffer winnerMember) {
        if (iterator.hasNext()) {
            winnerMember.append(", ");
        }
        return winnerMember;
    }

}
