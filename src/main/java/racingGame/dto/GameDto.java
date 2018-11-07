package racingGame.dto;

public class GameDto {

    private String carNames;
    private String turn;

    public GameDto(String carNames, String turn) {
        this.carNames = carNames;
        this.turn = turn;
    }

    public String getCarNames() {
        return carNames.replace(" ", ",");
    }

    public int getTurn() {
        return Integer.parseInt(turn);
    }
}
