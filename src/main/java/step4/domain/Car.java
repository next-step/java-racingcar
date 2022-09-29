package step4.domain;

import step4.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name.trim();
        this.position = 0;
    }

    public Car(String name, int position){
        validateName(name);
        this.name = name.trim();
        this.position = position;
    }


    private void validateName(String name) {
        if(isInvalidateName(name)){
            throw new IllegalStateException("자동차 이름은 " + MIN_NAME_LENGTH + "~" + MAX_NAME_LENGTH + "자여야 합니다.");
        }
    }

    private boolean isInvalidateName(String name) {
        return Objects.isNull(name) ||
                name.trim().length() < MIN_NAME_LENGTH ||
                name.trim().length() > MAX_NAME_LENGTH;
    }


    public void move(MoveStrategy strategy) {
        if(strategy.movable()){
            this.position += 1;
        }
    }


    public RacingRecord racingRecord(){
        return new RacingRecord(this.name, this.position);
    }


}


