package racing_car.step4.dto;

import racing_car.step4.domain.CarName;
import racing_car.step4.domain.Position;

public class CarDTO {
    private final int position;
    private final String carName;
    
    public CarDTO(CarName carName, Position position) {
        this.carName = carName.getCarName();
        this.position = position.getPosition();
    }
    
    public String getCarName() {
        return carName;
    }
    
    public int getPosition() {
        return position;
    }
}
