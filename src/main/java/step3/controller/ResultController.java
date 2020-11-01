package step3.controller;

import java.util.List;

public class ResultController {

    public void printRacingGame(List<List<Integer>> racingGameResult) {
        racingGameResult.stream().forEach(this::printRacingLog);
    }

    public void printRacingLog(List<Integer> racingStepResult) {
        racingStepResult.stream().forEach(this::printLocation);
        System.out.println("");
    }

    public void printLocation(Integer location) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < location; i++) {
            sb.append("-");
        }
        System.out.println(sb);
    }
}
