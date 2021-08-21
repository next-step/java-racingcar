package kr.co.techmoa.carracing.model;

public class CarName {

    private static final int CARNAME_MAX = 5;
    private String carName;

    public CarName(String carName){
        if(carName.length() > CARNAME_MAX) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        this.carName = carName;
    }

    public String getCarName() {
        return this.carName;
    }



}
