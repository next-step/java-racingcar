package step4.view;

import step4.domain.car.Car;
import step4.domain.racing.Cars;
import step4.dto.ResponseDto;

import java.util.List;

public final class ResultView {

    public ResultView() {
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


}
