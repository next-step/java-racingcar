package racewinner;

public class CarRacing {
    private final CarList carList = new CarList();
    public CarRacing(String inputCarListName) {
        String[] carNameList = inputCarListName.split(",");

        for (String carName: carNameList) {
            carList.add(carName);
        }
    }

}
