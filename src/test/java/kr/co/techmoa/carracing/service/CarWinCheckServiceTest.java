package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarWinCheckServiceTest {

    CarWinCheckService carWinCheckService = new CarWinCheckService();

    @Test
    public void checkGameResult() {

        List<Car[]> rounds = new ArrayList<>();
        Car[] cars = new Car[3];
        cars[0] = Car.builder().carName("joo").totalMove(4).build();
        cars[1] = Car.builder().carName("jabc").totalMove(9).build();
        cars[2] = Car.builder().carName("egg").totalMove(3).build();

        rounds.add(cars);
        List<Car> resultCar = carWinCheckService.checkGameResult(rounds);

        assertEquals(resultCar.get(0).getCarName() , "jabc" );
    }

}