package camp.nextstep.racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CarRacing {
  Random random = new Random();
  final int START_POSITION = 1;

  public void start(int carNumber, int rounds) {
    List<Integer> racingState = new ArrayList<Integer>(Collections.nCopies(carNumber, START_POSITION));
    this.tick(racingState, rounds);
  }

  public List<Integer> tick(List<Integer> racingState, int remainTicks) {
    if (remainTicks == 0) {
      return racingState;
    }
    printRacingState(racingState);
    return this.tick(this.performTick(racingState), remainTicks - 1);
  }

  public List<Integer> performTick(List<Integer> racingState) {
    List<Integer> newRacingState = racingState;
    for (int carIndex : IntStream.range(0, racingState.size()).toArray()) {
      if (random.nextInt(10) >= 4 ) {
        newRacingState = move(newRacingState, carIndex);
      }
    }
    return newRacingState;
  }

  public List<Integer> move(List<Integer> racingState, int carIndex) {
    racingState.set(carIndex, racingState.get(carIndex) + 1);
    return racingState;
  }

  private void printRacingState(List<Integer> racingState) {
    for(int position : racingState) {
      System.out.println(String.join("", Collections.nCopies(position, "-")));
    }
    System.out.println("");
  }

  static public int getCarNumber() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  static public int getRound() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  public static void main(String[] args) {
    int carNumber = getCarNumber();
    int rounds = getRound();

    CarRacing racing = new CarRacing();
    racing.start(carNumber, rounds);
  }
}
