package racingcar.domain;

public class CarStatDTO {
    public String racerName;
    public int position;
    public CarStatDTO(String racerName, int position) {
        this.racerName = racerName;
        this.position = position;
    }
    public String getRacerName() {
        return racerName;
    }

    public int getPosition() {
        return position;
    }
}
