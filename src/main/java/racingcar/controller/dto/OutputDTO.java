package racingcar.controller.dto;

import racingcar.model.entity.Car;

public class OutputDTO {
    private String name;
    private int step;

    public OutputDTO(final Car car){
        this.name = car.getName();
        this.step = car.getStep();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
