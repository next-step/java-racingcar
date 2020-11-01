package step3.present;

import step3.RaceGameContract;
import step3.model.Commander;
import step3.model.RacingCar;
import step3.model.RacingCars;

import java.util.ArrayList;
import java.util.List;

public class Presenter implements RaceGameContract.Presenter{

    private Commander commander;
    private RacingCars racingCars;
    private RaceGameContract.View view;

    public Presenter(RaceGameContract.View view, Commander commander) {
        this.view = view;
        this.commander = commander;
    }

    @Override
    public RacingCars createParticipantRacingCar(int participantCar) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < participantCar; i++) {
            cars.add(new RacingCar(i));
        }
        racingCars = new RacingCars(cars);
        return racingCars;
    }

    @Override
    public void orderCommand(int participant) {
        for (int i = 0; i < participant; i++) {
            String commands = commander.generateCommand();
            racingCars.getParticipantCar(i).addCommands(commands);
        }
        view.renderView(racingCars);
    }

}
