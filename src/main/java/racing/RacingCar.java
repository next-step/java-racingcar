package racing;

public class RacingCar {

    private final Driver driver;

    private int position;

    public RacingCar(String name) {
        this.driver = new Driver(name);
    }

    public void attack(boolean isAttackable) {
        if(isAttackable) {
            position += 1;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(driver.getName())
                .append(" : ");

        for(int i = 0; i < position; i++) {
            builder.append("-");
        }

        return builder.toString();
    }

    public Driver getDriver() {
        return this.driver;
    }

    public int getPosition() {
        return this.position;
    }
}
