package racingcar;

public class RacingCar {
    private String carName;
    private  int position;

    public RacingCar(String carName) {
        nameCheck(carName);

        this.carName = carName;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    public void nameCheck(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자 이상입니다");
        }
    }
    public void moveOrNot(int number) {
        if (number >= 4) {
            this.position++;
        }
    }

    public String dash(int position) {
        position = this.position;
        String dash = "";
        for(int i = 0; i < position; i++){
            dash.concat("-");        }
        return dash;
    }

}
