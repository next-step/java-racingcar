package racing.view;

import racing.car.Car;

import java.util.List;

public class ResultView {

    private final String carSymbol;

    public ResultView(String carSymbol) {
        this.carSymbol = carSymbol;
    }

    public void printRacingState(List<Car> carList) {
        carList.stream()
               .map(Car::getLocation)
               .forEach(location -> System.out.println(generateTrack(location)));

        System.out.println();
    }

    private String generateTrack(int location) {
        if (location == 0) {
            return "";
        }

        return new String(new char[location]).replace("\0", this.carSymbol);
    }


}
