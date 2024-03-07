package carRacing.race;

import carRacing.car.Cars;

public class RacingGameUiImpl implements RacingGameUI{
    private static final String TRACK_SYMBOL = "-";

    @Override
    public void printTrack(Cars cars, int trialCount) {
        System.out.println((trialCount + 1) + "회차 이동");
        cars.forEach(car -> {
            System.out.print(car.getName()+" : ");
            for (int track = 0; track < car.getPosition(); track++) {
                System.out.print(TRACK_SYMBOL);
            }
            System.out.println();
        });
        System.out.println();
    }

    @Override
    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
