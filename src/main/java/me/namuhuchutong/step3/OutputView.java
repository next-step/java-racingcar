package me.namuhuchutong.step3;

public class OutputView {

    public void printResult(RacingResult racingResult) {
        printThroughStandardOut(racingResult);
    }

    private void printThroughStandardOut(RacingResult racingResult) {
        racingResult.getCarsList().forEach(System.out::println);
  }
}
