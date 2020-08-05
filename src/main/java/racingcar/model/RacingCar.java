package racingcar.model;

public class RacingCar {
    private String carNumber;
    private int carPosition;

    public RacingCar(String carNumber){
        this.carNumber = carNumber;
    }

    public Integer getCarPosition() {
        return carPosition;
    }

    public void run(Rule racingRule) {
        if(racingRule.checkRule()) {
            carPosition++;
        }
    }

    public String makeMark(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
