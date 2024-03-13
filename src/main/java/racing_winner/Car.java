package racing_winner;


public class Car {

    private static final String LOCATION_TOKEN = "-";
    private static final int MAX_INT = 4;

    private int level;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLevel(){
        return level;
    }

    public void tryMove(int nextInt) {
        if(nextInt < MAX_INT)
            level++;
    }

    public String getStatus(){
        return name + " : " + LOCATION_TOKEN.repeat(level);
    }
}
