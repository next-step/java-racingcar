package racingcar;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingResult;
import racingcar.domain.Record;
import racingcar.exception.RacingGameException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {

    private List<RacingCar> racingCars;
    private List<Lab> labs;
    private boolean finished;

    public RacingGame(int labCount) {
        finished = false;

        initLabs(labCount);
        racingCars = new ArrayList<>();
    }

    private void initLabs(int labCount) {
        labs = new ArrayList<>();

        for (int i=1 ; i<=labCount ; i++) {
            labs.add(new Lab(i));
        }
    }

    public void registerCar(RacingCar racingCar) {
        checkFinished();

        racingCars.add(racingCar);
    }

    public RacingResult start() {
        checkFinished();
        checkRegisteredCars();

        List<Record> records = labs.stream()
                .map(Lab::start)
                .collect(Collectors.toList());

        finished = true;

        return new RacingResult(records);
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
        int labNum;

        private Lab(int labNum) {
            this.labNum = labNum;
        }

        private Record start() {
            racingCars.forEach(RacingCar::move);
            return Record.record(labNum, racingCars);
        }
    }

}
