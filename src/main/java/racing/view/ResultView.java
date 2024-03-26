package racing.view;

import racing.domain.Car;
import racing.domain.RacingCars;
import racing.domain.RacingHistory;

import java.util.Iterator;
import java.util.Set;

public class ResultView {

    public static void showRaceResult(Set<RacingHistory> racingHistory) {
        Iterator<RacingHistory> historyIterator = racingHistory.iterator();
        while (historyIterator.hasNext()) {
            RacingHistory nextRound = historyIterator.next();
            showRaceRound(nextRound.getRound(), nextRound.getHistorySet());
        }
    }

    private static void showRaceRound(Integer round, Set<Car> racingCarsSet) {
        if (round == 1) {
            System.out.println();
            System.out.println("실행 결과");
        }
        Iterator<Car> iterator = racingCarsSet.iterator();
        while (iterator.hasNext()) {
            showCarLocation(iterator.next());
            System.out.println();
        }
        System.out.println();
    }

    private static void showCarLocation(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
    }

    public static void showRaceWinner(RacingCars racingCars) {
        StringBuilder sb = new StringBuilder();
        Iterator<Car> winCarIterator = racingCars.getWinCarList().iterator();
        while (winCarIterator.hasNext()) {
            sb.append(winCarIterator.next().getName()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
    }

}
