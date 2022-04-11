package newcarracing;

public class RacingCar {
    private static final int MAX_LENGTH_OF_NAME = 5;

    private String name;
    private Integer position;

    public RacingCar(String name) {
        if(name.length() > MAX_LENGTH_OF_NAME){
            throw new IllegalCallerException("자동차의 이름은 " + MAX_LENGTH_OF_NAME + "자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public RacingCar(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
