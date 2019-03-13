package racingcar.web.dto;

public class RunResultDTO {
    private String carName;
    private String result;

    public RunResultDTO(String carName, String result) {
        this.carName = carName;
        this.result = result;
    }

    public String getCarName() {
        return carName;
    }

    public String getResult() {
        return result;
    }
}
