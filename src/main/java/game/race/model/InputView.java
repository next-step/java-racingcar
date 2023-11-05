package game.race.model;

public class InputView {

    private int vehicleCnt;

    private int tryCnt;

    public int getVehicleCnt() {
        return vehicleCnt;
    }

    public void setVehicleCnt(int vehicleCnt) {
        this.vehicleCnt = vehicleCnt;
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public void setTryCnt(int tryCnt) {
        this.tryCnt = tryCnt;
    }

    public void checkInput(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("값을 입력 하세요.");
        }

        if (number == 0) {
            throw new IllegalArgumentException("0보다 큰 수를 넣어 주세요.");
        }
    }
}
