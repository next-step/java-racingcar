package step4.view;

import step4.domain.Car;

public class ResultView {

    public void render(Car car) {
        StringBuffer line = new StringBuffer();
        line.append(car.myName() + " : ");
        for(int i = 0; i < car.myPosition(); i++){
            line.append("-");
        }
        System.out.println(line.toString());
    }

    public void result(String winners){

    }
}
