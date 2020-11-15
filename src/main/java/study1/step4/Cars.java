package study1.step4;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String racerListString){
        Tokenizer.TokenListValidate(racerListString);
        initializeCars(Tokenizer.getList(racerListString));
    }
    private void initializeCars(String[] racerList){
        for(String racer: racerList){
            cars.add(new Car(racer, 1));
        }
    }

    public void race(Decision moveDecisionMaker){
        this.cars.forEach(car -> car.move(moveDecisionMaker));
    }

    public int getCarsSize() {
        return cars.size();
    }

    public Car getCar(int index){
        return cars.get(index);
    }
}
