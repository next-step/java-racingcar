package racinggame;

public class CarDTO {

    private String[] carNames;
    private int tryCnt;
    private int location;

    public String[] getCarNames() {
        return carNames;
    }

    public void setCarNames(String[] carNames) {
        this.carNames = carNames;
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public void setTryCnt(int tryCnt) {
        this.tryCnt = tryCnt;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
