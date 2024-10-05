package racingCar.step5.domain;

public class RacingCar {
    private final String name;

    public RacingCar(final String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름을 5자 이하로 입력해주세요.");
        }
        this.name = name;
    }
}
