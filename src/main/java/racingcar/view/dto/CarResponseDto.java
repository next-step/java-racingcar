package racingcar.view.dto;

import racingcar.domain.Car;

public class CarResponseDto {
    private static final String SPACE = "&nbsp;";
    private static final String CAR_EMOTICON = "&#128652;";
    private static final String PATH = "-";
    private int position;
    private String name;
    private String statusResult;

    public CarResponseDto(Car car) {
        this.position = car.getPosition();
        this.name = car.getName();
        this.statusResult = produceStatus();
    }

    private String produceStatus() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position - 1; i++) {
            sb.append(SPACE);
        }
        sb.append(CAR_EMOTICON);
        return sb.toString();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getStatusResult() {
        return statusResult;
    }
}
