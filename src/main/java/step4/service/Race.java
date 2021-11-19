package step4.service;

import step4.dto.RandomStrategy;
import step4.dto.RunStrategy;
import step4.dto.car.Car;
import step4.dto.car.CarGroup;
import step4.dto.count.TrialCount;
import step4.dto.name.CarNameGroup;
import step4.dto.record.RecordGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private TrialCount trialCount;
    private CarGroup carGroup;

    public Race(CarNameGroup carNameGroup, TrialCount trialCount) {
        this.trialCount = trialCount;

        initCarGroup(carNameGroup);
    }

    private void initCarGroup(CarNameGroup carNameGroup) {
        RunStrategy runStrategy = new RandomStrategy();

        List<Car> cars = carNameGroup.getCarNameGroup().stream()
                .map(name -> new Car(runStrategy, name))
                .collect(Collectors.toList());

        carGroup = new CarGroup(cars);
    }

    public List<RecordGroup> start() {
        List<RecordGroup> recordGroup = new ArrayList<>();

        while (!trialCount.isEndTrialCount()) {
            carGroup.run();
            recordGroup.add(carGroup.carsCurrentPosition());

            trialCount.subtractTrialCount();
        }
        return recordGroup;
    }

    public CarNameGroup raceAwards() {
        return carGroup.findWinner();
    }
}
