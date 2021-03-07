package dev.djoon.racingcar.ui;

public class ResultView {
  public static void printNewGame() {
    System.out.println("실행 결과");
  }

  public static void printXPos(int xPos) {
    System.out.print("-"); /** 기본 출발선(=0) **/
    for (int i = 0; i < xPos; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  public static void printCR() {
    System.out.println();
  }
}
