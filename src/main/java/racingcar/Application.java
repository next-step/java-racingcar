package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Ready ready = new Ready();

        // input
        String carName = input.carName();
        int gameCount = input.gameCount();

        // Ready : 자동차 목록 생성(input 값 받아서 자동차 만들기)
        List<Car> cars = ready.createCars(carName);

        // Stadium : 경기장 생성, 게임하기
        Stadium stadium = new Stadium(cars, gameCount);
        List<Car> result = stadium.playRace();

        // Awards : 시상식(우승자 발표)
    }
}