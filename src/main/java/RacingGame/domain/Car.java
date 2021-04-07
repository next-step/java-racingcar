package RacingGame.domain;

import RacingGame.dto.CarDto;

public class Car {

    private int location;
    private String name;
    private static final int STARTING_LOCATION = 0;
    private static final int MAX_NAME_LENGTH = 5;

    public Car(){
        this.location = STARTING_LOCATION;
    }

    public Car(String name){
        this.location = STARTING_LOCATION;
        if (notValidName(name)){
            throw new IllegalStateException("차의 이름은 5자 이하이고 공백이 아니여야 합니다.");
        }
        this.name = name;

    }

    public int isAt(){
        return this.location;
    }

    public String carName(){
        return this.name;
    }

    public void move(Rule rule) {
        if (rule.move())
            this.location = ++location;
    }

    public Boolean notValidName(String name){
        return name == null || name.length() > MAX_NAME_LENGTH || name.trim().isEmpty(); // NPE방지위해 null
    }

    public CarDto getCarDto(){
        return new CarDto(name,location);
    }
}
