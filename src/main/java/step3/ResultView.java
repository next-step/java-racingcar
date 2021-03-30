package step3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public ResultView() {}

    public void printStart() {
        System.out.println("\n실행 결과");
    }

    public void printRacingCar(String carName, int moveCount) {
        System.out.print(carName + " : ");
        while (moveCount > 0) {
            System.out.print("-");
            moveCount--;
        }
        System.out.println();
    }

    private int getMaxMoveCount(ArrayList<RacingCar> carList) {
        return carList
                .stream()
                .max(Comparator.comparing(RacingCar::getMoveCount))
                .get().getMoveCount();
    }

    private String getWinnerList(ArrayList<RacingCar> carList) {
        int maxMoveCount = getMaxMoveCount(carList);

        List<String> winnerList = carList
                .stream()
                .filter(racingCar -> racingCar.getMoveCount() == maxMoveCount)
                .collect(Collectors.toList())
                .stream().map(RacingCar::getCarName).collect(Collectors.toList());

        return String.join(", ", winnerList);
    }

    public void lastPrint(ArrayList<RacingCar> carList) {
        String names = getWinnerList(carList);
        System.out.println(names + "가 최종 우승했습니다.");
    }
}
