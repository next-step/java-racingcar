package racing_car.step3.dto;

import racing_car.step3.domain.Position;

public class CarDTO {
    private final Position position;
    
    public CarDTO(Position position) {
        this.position = position;
    }
    
    public Position getPosition() {
        return position;
    }
}
