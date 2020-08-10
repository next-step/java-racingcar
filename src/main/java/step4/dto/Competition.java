package step4.dto;

import java.util.List;

public class Competition {

    private List<String> carNames;
    private int rount;

    private Competition(List<String> carNames, int rount) {
        this.carNames = carNames;
        this.rount = rount;
    }

    public static Competition create(List<String> carNames, int rount) {
        return new Competition(carNames, rount);
    }

    public List<String> getPaticipate() {
        return carNames;
    }

    public int getRount() {
        return rount;
    }
}
