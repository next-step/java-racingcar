package car.controller;

import car.domain.CarRacing;
import car.domain.CarResult;
import car.view.CarNameRequest;
import car.view.PlayNumberRequest;

public class CarController {
    public static void main(String[] args){
        CarNameRequest carNameRequest = CarNameRequest.carListRequest();
        PlayNumberRequest playNumberRequest = PlayNumberRequest.playNumberRequest();
        CarRacing carRacing = new CarRacing(carNameRequest.getCarNameList(), playNumberRequest.getNumber());
        new CarResult(carRacing.getCarList());
    }
}
