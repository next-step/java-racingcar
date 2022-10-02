package thirdStep.View;

import thirdStep.logic.Race;

import java.util.stream.IntStream;

public class ResultView {

    public static void main(String[] args) {
        InputView.inputCarCount();
        InputView.inputRaceCount();
        ResultView.printResult();
    }

    private static void printResult() {
        System.out.println("실행결과");
        for (int i = 0; i < InputView.getRaceCount(); i++) {
            printOneRace();
            System.out.println();
        }
    }

    private static void printOneRace() {
        Race.startOneRace();
        int[] carStatus = Race.getCarStatus();
        for (int i = 0; i < carStatus.length; i++) {
            System.out.println(makeString(carStatus[i]));
        }
    }

    private static StringBuilder makeString(int number) {
        StringBuilder carMoveResult = new StringBuilder("-");
        IntStream.range(0, number).mapToObj(i -> "-").forEach(carMoveResult::append);
        return carMoveResult;
    }
}
