package racing.dto;

public class WebRacingGameResultDto {
    private String carName;
    private int movePosition;

    public WebRacingGameResultDto(String carName, int movePosition) {
        this.carName = carName;
        this.movePosition = movePosition;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getMovePosition() {
        return this.movePosition;
    }
}
