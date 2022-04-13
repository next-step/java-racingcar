package newcarracing;

public class RacingCar implements Comparable<RacingCar>{
    private static final int MAX_LENGTH_OF_NAME = 5;
    private static final String ROUTE = "-";

    private String name;
    private int position;

    public RacingCar(String name) {
        if(name.length() > MAX_LENGTH_OF_NAME){
            throw new IllegalArgumentException("자동차의 이름은 " + MAX_LENGTH_OF_NAME + "자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position += 1;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    };

    public String createRacingCarRoute(RacingCar car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getName() + " : ");
        for(int i=0; i < this.position; i++) {
            stringBuilder.append(ROUTE);
        }
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(RacingCar car) {
        return this.position - car.getPosition();
    }
}
