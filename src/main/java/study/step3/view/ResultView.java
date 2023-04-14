package study.step3.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import study.step3.domain.Car;

public class ResultView {

  private static final int START_RACE_NUM = 0;
  private static final String FOOTPRINT = "-";

  private ResultView() {
  }

  public static void printResult(int raceNum, List<Car> cars) {
    printRaceNum(raceNum);
    printCars(cars);
  }

  private static void printRaceNum(int raceNum) {
    if (isStartLine(raceNum)) {
      System.out.print("\n실행 결과");
    }
    System.out.println("\nRACE " + (raceNum + 1));
  }

  private static boolean isStartLine(int raceNum) {
    return raceNum == START_RACE_NUM;
  }

  private static void printCars(List<Car> cars) {
    for (Car car : cars) {
      System.out.println(car.getName()+" : "+FOOTPRINT.repeat(car.getDistance()));
    }
  }

  public static void printWinners(List<Car> cars){
    List<String> winners = getWinnerNames(sortCars(cars));
    printWinnerNames(winners);
  }

  private static List<Car> sortCars(List<Car> cars) {
    Collections.sort(cars, (car1, car2)->{
      return car2.getDistance() - car1.getDistance();
    });
    return cars;
  }

  private static List<String> getWinnerNames(List<Car> cars) {
    int max = cars.get(0).getDistance();
    List<String> winners = new ArrayList<>();
    for (Car car : cars) {
      if(car.getDistance() != max) break;
      winners.add(car.getName());
    }
    return winners;
  }

  private static void printWinnerNames(List<String> winners){
    String result = "\n";
    for (int i = 0; i < winners.size()-1; i++) {
      result += winners.get(i)+", ";
    }
    result += winners.get(winners.size()-1) + "가 최종 우승했습니다.";
    System.out.println(result);
  }
}
