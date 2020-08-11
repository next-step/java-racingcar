package com.cspark.nextstep.step3.ui;

import com.cspark.nextstep.step3.domain.Scorecard;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

  public static void displayLap(List<Scorecard> scorecards) {
    for (Scorecard scorecard : scorecards) {
      printSkidMark(scorecard.getName(), scorecard.getForwardCount());
    }
    System.out.print(System.lineSeparator());
  }

  private static void printSkidMark(String name, long forwardCount) {
    System.out.println(String.format("%5s : %s", name, createSkidMark(forwardCount)));
  }

  private static String createSkidMark(long forwardCount) {
    return forwardCount == 0 ?
        "" :
        String.format("%" + forwardCount + "s", "").replaceAll(" ", "-");
  }

  public static void displayWinner(List<Scorecard> podium) {
    System.out.println(String.format("%s가 최종 우승했습니다.",
        podium.stream()
            .map(d -> d.getName())
            .collect(Collectors.joining(", ")))
    );
  }

}
