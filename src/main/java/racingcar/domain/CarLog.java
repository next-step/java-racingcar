package racingcar.domain;

import lombok.Getter;

@Getter
public class CarLog {
    private String name;
    private int position;

    public CarLog(String name, int position) {
        this.name = name;
        this.position = position;
    }
}
