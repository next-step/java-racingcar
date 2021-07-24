package CarRacing;

public class CarMove {

    private int carMovingDistance = 0;
    private StringBuffer sb = new StringBuffer();


    public void increaseCarDistance(int carMove) {
        if (carMove > 3) {
            this.carMovingDistance++;
        }
    }

    public StringBuffer getCarMovingDistance() {

        sb.setLength(0);

        for (int i = 0; i < carMovingDistance; i++) {
            sb.append("-");
        }
        return sb;
    }
}
