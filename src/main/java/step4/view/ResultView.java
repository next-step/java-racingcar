package step4.view;

import step4.domain.car.Car;
import step4.domain.racing.Cars;
import step4.domain.racing.Winners;
import step4.dto.ResponseDto;

import java.util.List;

public final class ResultView {

    private static ResultView instance;

    private ResultView() {
    }

    public static ResultView getInstance(){
        if(instance == null) {
            instance = new ResultView();
        }
        return instance;
    }

    private boolean isInstanceNull(){
        return instance == null;
    }

    public void printRacingEndMessage() {
        System.out.println("실행 결과");
    }

    public void print(ResponseDto responseDto){
        Cars cars = responseDto.cars();
        List<Car> carList = cars.cars();

        for(Car car : carList) {
            System.out.print(car.name().name());
            System.out.print(" : ");
            for(int i=0; i < car.position().position(); i++) {
                System.out.print("-");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void print(Winners winners){

    }

}
