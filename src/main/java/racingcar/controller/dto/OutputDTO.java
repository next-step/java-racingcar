package racingcar.controller.dto;

public class OutputDTO {

    private String resultMessage;

    public OutputDTO(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultMessage() {
        return resultMessage;
    }

}
