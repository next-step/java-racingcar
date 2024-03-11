package carRacing.race;

import carRacing.car.Cars;

import java.util.stream.IntStream;

public class RacingGameUI {
    private static final String TRACK_SYMBOL = "-";

    public void printTrack(Cars cars, int trialCount) {
        System.out.println((trialCount + 1) + "회차 이동");
        cars.forEach(car -> {
            System.out.print(car.getName()+" : ");
            IntStream.range(0, car.getPosition()).forEach(i-> System.out.print(TRACK_SYMBOL));
            System.out.println();
        });
        System.out.println();
    }

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
