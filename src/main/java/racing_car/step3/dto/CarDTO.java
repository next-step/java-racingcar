package racing_car.step3.dto;

import racing_car.step3.domain.Position;

public class CarDTO {
    private final int position;
    
    public CarDTO(Position position) {
        this.position = position.getPosition();
    }
    
    public int getPosition() {
        return position;
    }
}
