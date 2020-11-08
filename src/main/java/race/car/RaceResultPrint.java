package race.car;

import java.util.ArrayList;
import java.util.List;

/**
 * 결과를 그려주는 객체
 */
public class RaceResultPrint {

    public static void runPrintRaceResult(Car car) {
        List<List<CarRaceMoveInfo>> carReacMoveInfoList = new ArrayList<>();

        for (String name : car.getRaceCarNames()) {
            carReacMoveInfoList.add(car.getCarReacMoveInfoList().get(name));
        }

        printPaceResult(carReacMoveInfoList, car.getRaceTryCount());
        runPrintCarRaceWinner(car);
    }

    private static void printPaceResult(List<List<CarRaceMoveInfo>> carReacMoveInfoList, int raceTryCount) {
        for (int i = 0; i < raceTryCount; i++) {
            repeatCarReacMoveInfoList(carReacMoveInfoList, i);
            System.out.print(System.lineSeparator());
        }
    }

    private static void repeatCarReacMoveInfoList(List<List<CarRaceMoveInfo>> carReacMoveInfoList, int index) {
        for (int i = 0; i < carReacMoveInfoList.size(); i++) {
            System.out.print(carReacMoveInfoList.get(i).get(index).getRaceCarName()
                    + " : "
                    + changeNumberToChar(carReacMoveInfoList.get(i).get(index).getMoveDistance()));
            System.out.print(System.lineSeparator());
        }
    }

    private static String changeNumberToChar(int count) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < count; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    private static void runPrintCarRaceWinner(Car car) {
        List<CarRaceMoveInfo> raceWinnerList = ExtractWinner.ExtractRun(car);

        System.out.print("우승자 : " + raceWinnerList.get(0).getRaceCarName());

        for (int i = 1; i < raceWinnerList.size(); i++) {
            System.out.print(", " + raceWinnerList.get(i).getRaceCarName());
        }
        System.out.print(System.lineSeparator());
    }
}