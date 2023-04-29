package racingcar.car;

import org.apache.commons.lang3.StringUtils;
import racingcar.numbergenerator.NumberGenerator;

public class Car {

    private final static int MOVE_STRATEGY_NUMBER = 4;
    private Position position;
    private Name name;

    private Car(int position, String name) {
        this.position = Position.from(position);
        this.name = Name.from(name);
    }

    public static Car from(String name){
        return new Car(0, name);
    }
    public void move(NumberGenerator numberGenerator){
        if(numberGenerator.generate() >= MOVE_STRATEGY_NUMBER){
            this.position.move();
        }
    }

    public int getPosition(){
        return position.position;
    }

    public String getName() {
        return name.name;
    }

    private static class Position{

        private int position;

        private Position(int position) {
            this.position = position;
        }

        private static Position from(int position){
            return new Position(position);
        }

        private void move(){
            this.position++;
        }


    }

    private static class Name{

        private final static int LENGTH_LIMIT = 5;
        private final String name;

        private Name(String name){
            this.name = name;
        }

        public static Name from(String name){
            if(StringUtils.isBlank(name)){
                throw new RuntimeException("자동차 이름은 항상 있어야 합니다!");
            }
            if(name.length() > LENGTH_LIMIT){
                throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다! 잘못된 이름"+name);
            }

            return new Name(name);
        }
    }

}
