package racingCar.step5.domain;

public class RacingCar {
    private final String name;
    private final int position;

    public RacingCar(final String name) {
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름을 5자 이하로 입력해주세요.");
        }
        this.name = name;
        this.position = position;
    }

    public static RacingCar ofName(final String name) {
        return new RacingCar(name);
    }

    public static RacingCar ofNameAndPosition(final String name, final int position) {
        return new RacingCar(name, position);
    }

    public int maxPosition(int otherPosition) {
        if(position < otherPosition){
            return otherPosition;
        }
        return position;
    }
}
