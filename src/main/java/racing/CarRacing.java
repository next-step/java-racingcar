package racing;

import racing.inout.OutPutView;

public class CarRacing {
    private final ParticipationCars participationCars;
    private final Referee referee;
    private final int howManyTimesToTry;

    private CarRacing(ParticipationCars participationCars, int howManyTimesToTry, Referee referee) {
        this.participationCars = participationCars;
        this.howManyTimesToTry = howManyTimesToTry;
        this.referee = referee;
    }

    public static CarRacing defaultOf(ParticipationCars participationCars, int howManyTimesToTry, Referee referee) {
        return new CarRacing(participationCars,howManyTimesToTry, referee);
    }

    public void start(OutPutView outPutView) {
        for (int i = 0; i < howManyTimesToTry; i++) {
            participationCars.move(referee);
            participationCars.printStatus(outPutView);
        }
        Winners winners = participationCars.voteWinner();
        winners.printWinners(outPutView);
    }
}
