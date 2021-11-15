package view;

import domain.CarRaceGroup;
import domain.CarRaceResult;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String NEXT_LINE = "\n";
    private static final String POSITION_MARK = "-";
    private static final String EMPTY = "";
    private static final String CAR_RACE_RESULT_MESSAGE = "%s : %s \n";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    public static void resultCarRace(List<CarRaceGroup> result) {
        System.out.println(RESULT_MESSAGE);

        int loopNumber = result.size();
        for (int i = 0; i < loopNumber; i++) {
            printCarPosition(result.get(i));
        }
    }

    private static void printCarPosition(CarRaceGroup carRaceGroup) {
        int carRaceGroupSize = carRaceGroup.size();
        for (int i = 0; i < carRaceGroupSize; i++) {
            System.out.printf(CAR_RACE_RESULT_MESSAGE, carRaceGroup.name(i), changeNumberToHyphen(carRaceGroup.position(i)));
        }
        System.out.print(NEXT_LINE);
    }

    private static String changeNumberToHyphen(int loopNumber) {
        String carLocation = EMPTY;
        for (int i = 0; i < loopNumber; i++) {
            carLocation += POSITION_MARK;
        }

        return carLocation;
    }

    public static void winner(CarRaceResult carRaceResult) {
        System.out.printf(WINNER_MESSAGE, carRaceResult.winnerName());
        System.out.printf(NEXT_LINE);
    }

}
