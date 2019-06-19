public class CarInfo {
    private String carName;
    private int carPosition;
    private String carStatus;

    public int getCarPosition(){return carPosition;}
    public String getCarStatus(){return carStatus;}
    public String getCarName() {return  carName;}

    public void setCarName(String carName ){
        this.carName = carName;
    }
    public void setCarPositions(int carPosition) {this.carPosition = carPosition; }
    public void setCarStatus(String carStatus) {this.carStatus = carStatus;}
}
