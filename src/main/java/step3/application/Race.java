package step3.application;

import step3.application.domain.CarGroup;

public class Race {

    private final CarGroup carGroup = new CarGroup();

    public int countRacingCar() {
        return this.carGroup.queryRacingGroup().size();
    }

    public void createCars(int count) {
        carGroup.createGroup(count);
    }
}