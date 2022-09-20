package racing_car.step3.dto;

import racing_car.step3.domain.Car;

public class CarDTO {
    private final int position;
    
    public CarDTO(int position) {
        this.position = position;
    }
    
    public int getPosition() {
        return position;
    }
}
