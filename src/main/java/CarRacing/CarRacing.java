package CarRacing;

public class CarRacing {
    private CarList carList = new CarList();
    private int numberOfAttempts;

    public CarRacing(int carCount, int numberOfAttempts) {
        if (carCount == 0 || numberOfAttempts == 0) {
            throw new IllegalArgumentException("자동차 개수나 시도 횟수는 0이 아닌값을 넣어 주세요.");
        }
        setCarList(carCount);
        this.numberOfAttempts = numberOfAttempts;
    }

    public void setCarList(int carCount) {
        carList.addCar(carCount);
    }

    public void raceStart() {
        for (int i = 0; i < numberOfAttempts; i++) {
            carList.movingCarList();
            carList.getCarListDistance();
        }
    }


}
