package step3.model;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {

    private RacingCars racingCars;
    private GameRound round;
    private Commander commander;

    public RaceGame(GameRound round, Commander commander) {
        this.round = round;
        this.commander = commander;
        createParticipantRacingCar();
    }

    private void createParticipantRacingCar() {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < round.getParticipantCar(); i++) {
            cars.add(new RacingCar(i));
        }
        this.racingCars = new RacingCars(cars);
    }

    public RacingCars nextRound() {
        for (int i = 0; i < round.getParticipantCar(); i++) {
            String commands = commander.generateCommand();
            racingCars.getParticipantCar(i).addCommands(commands);
        }
        round.roundFinish();
        return racingCars;
    }


}
