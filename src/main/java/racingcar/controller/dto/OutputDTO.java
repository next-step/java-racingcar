package racingcar.controller.dto;

import racingcar.model.entity.Car;

public class OutputDTO {
    private String resultMessage;

    public OutputDTO(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultMessage() {
        return resultMessage;
    }

}
