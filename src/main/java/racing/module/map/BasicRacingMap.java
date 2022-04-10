package racing.module.map;

import java.util.List;
import racing.Car;

public class BasicRacingMap implements RacingMap{

    private static final StringBuilder sb = new StringBuilder();
    private List<Car> cars;

    public BasicRacingMap(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void showCars(){
        for (Car car : cars) {
            int position = car.currentPosition();
            showCarPosition(position);
        }
        System.out.println();
    }

    private void showCarPosition(int position) {
        for(int i = 0; i < position; i++){
            sb.append("-");
        }
        System.out.println(sb);
        clearStringBuilder(sb);
    }

    private void clearStringBuilder(StringBuilder sb){
        sb.setLength(0);
    }

}
