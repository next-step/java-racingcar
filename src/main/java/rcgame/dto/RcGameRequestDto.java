package rcgame.dto;

public class RcGameRequestDto {
    private int carNumber;
    private int time;

    public RcGameRequestDto(int carNumber, int time) {
        this.carNumber = carNumber;
        this.time = time;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getTime() {
        return time;
    }
}
