package race.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 결과를 그려주는 객체
 */
public class RaceResultPrint {

    public void runPrintRaceResult(RunCarRace runCarRace) {
        RunCarRace carRace = new RunCarRace();
        List<List<CarRaceMoveInfo>> carReacMoveInfoList = carRace.carReacMoveInfoList(runCarRace);

        printPaceResult(carReacMoveInfoList);
        runPrintCarRaceWinner(runCarRace);
    }

    private void printPaceResult(List<List<CarRaceMoveInfo>> carReacMoveInfoList) {
        for (int i = 0; i < carReacMoveInfoList.get(0).size(); i++) {
            repeatCarReacMoveInfoList(carReacMoveInfoList, i);
            System.out.print(System.lineSeparator());
        }
    }

    private void repeatCarReacMoveInfoList(List<List<CarRaceMoveInfo>> carReacMoveInfoList, int index) {
        for (int i = 0; i < carReacMoveInfoList.size(); i++) {
            System.out.print(carReacMoveInfoList.get(i).get(index).getRaceCarName()
                    + " : "
                    + changeNumberToChar(carReacMoveInfoList.get(i).get(index).getMoveDistance()));
            System.out.print(System.lineSeparator());
        }
    }

    private String changeNumberToChar(int count) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < count; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    private void runPrintCarRaceWinner(RunCarRace runCarRace) {
        WinnerExtract winnerExtract = new WinnerExtract();
        List<CarRaceMoveInfo> raceWinnerList = winnerExtract.runExtract(runCarRace);

        System.out.print("우승자 : " + raceWinnerList.get(0).getRaceCarName());

        for (int i = 1; i < raceWinnerList.size(); i++) {
            System.out.print(", " + raceWinnerList.get(i).getRaceCarName());
        }
        System.out.print(System.lineSeparator());
    }
}