package racing.view;

import racing.model.Car;

import racing.model.RacingCars;

import java.util.stream.IntStream;

public class ResultView {
    private final String RESULT_MESSAGE = "실행결과";
    private final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRacingResult(RacingCars cars) {
        for (Car car : cars.getCandidates()) {
            System.out.print(car.getCarName()+" : ");
            IntStream.rangeClosed(0, car.currentLocation())
                    .forEach(x -> System.out.print("-"));
            System.out.println();
        }
        System.out.println();
    }

    public void printWinner(RacingCars cars){
        System.out.println(String.join(", ", cars.getWinners())+WINNER_MESSAGE);
    }
}
