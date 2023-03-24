package racing;

public class RacingCar {

    private final Driver driver;

    private final Position position;

    public RacingCar(String name) {
        this.driver = new Driver(name);
        this.position = new Position();
    }

    public void attack(boolean isAttackable) {
        if(isAttackable) {
            this.position.attack();
        }
    }

    public String printPosition() {
        StringBuilder builder = new StringBuilder(driver.getName())
                .append(" : ");

        for(int i = 0; i < this.position.getPoistion(); i++) {
            builder.append("-");
        }

        return builder.toString();
    }

    public Driver getDriver() {
        return this.driver;
    }

    public Position getPosition() {
        return this.position;
    }
}
