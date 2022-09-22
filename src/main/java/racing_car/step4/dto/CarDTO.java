package racing_car.step4.dto;

import racing_car.step4.domain.Name;
import racing_car.step4.domain.Position;

public class CarDTO {
    private final int position;
    private final String name;
    
    public CarDTO(Name name, Position position) {
        this.name = name.getName();
        this.position = position.getPosition();
    }
    
    public String getName() {
        return name;
    }
    
    public int getPosition() {
        return position;
    }
}
