package newcarracing;

public class RacingCar implements Comparable<RacingCar>, Cloneable {
    private static final int MAX_LENGTH_OF_NAME = 5;

    private String name;
    private int position;

    public RacingCar(String name) { // 점층적 생성자 패턴 적용.
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        if(name.length() > MAX_LENGTH_OF_NAME){
            throw new IllegalArgumentException("자동차의 이름은 " + MAX_LENGTH_OF_NAME + "자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(GameRule gameRule) {
        if(gameRule.checkCondition()) {
            this.position += 1;
        }
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    };

    @Override
    public int compareTo(RacingCar car) {
        return this.position - car.getPosition();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
