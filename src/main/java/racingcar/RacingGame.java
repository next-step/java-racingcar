package racingcar;

import racingcar.broadcast.Broadcast;
import racingcar.exception.RacingGameException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {

    private final Broadcast broadcast;
    private boolean finished = false;
    private List<RacingCar> racingCars;
    private List<Lab> labs;

    public RacingGame(int labCount, Broadcast broadcast) {
        initLabs(labCount);
        racingCars = new ArrayList<>();
        this.broadcast = broadcast;
    }

    private void initLabs(int labCount) {
        labs = new ArrayList<>();

        for (int i=0 ; i<labCount ; i++) {
            labs.add(new Lab());
        }
    }

    public void registerCar(RacingCar racingCar) {
        checkFinished();

        racingCars.add(racingCar);
    }

    public void start() {
        checkFinished();
        checkRegisteredCars();

        broadcast.open();

        labs.forEach(Lab::go);

        broadcast.end();

        finished = true;
    }

    private void checkRegisteredCars() {
        if (Objects.isNull(racingCars)|| racingCars.size() == 0) {
            throw new RacingGameException("참가한 차량이 없습니다.");
        }
    }

    private void checkFinished() {
        if (finished) {
            throw new RacingGameException("이미 종료된 게임입니다.");
        }
    }

    private class Lab {
        private Lab() {}

        private void go() {
            racingCars.stream()
                    .map(RacingCar::move)
                    .forEach(position -> broadcast.comment(position.toString()));

            broadcast.comment("lab 1 finished");
        }
    }

}
