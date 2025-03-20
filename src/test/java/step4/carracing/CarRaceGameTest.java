package step4.carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CarRaceGameTest {

  @DisplayName("자동차 경주 게임을 실행하는 기능 테스트")
  @Test
  void testCarRaceGame() {
    Scanner testScanner = new Scanner("pobi, crong, honux" + "\n" + "2" + "\n");
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    CarRaceGame carRaceGame = new CarRaceGame(testScanner);
    carRaceGame.start();

    System.setOut(originalOut);
    Assertions.assertTrue(outputStream.toString().contains("가 최종 우승했습니다."));
  }
}