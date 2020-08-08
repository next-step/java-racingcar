package step4.dto;

public class Competition {

    private String[] carNames;
    private int rount;

    private Competition(String[] carNames, int rount) {
        this.carNames = carNames;
        this.rount = rount;
    }

    public static Competition create(String[] carNames, int rount) {
        return new Competition(carNames, rount);
    }

    public String[] getPaticipate() {
        return carNames;
    }

    public int getRount() {
        return rount;
    }
}
