package racingcar;

import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void racingCars() {
        //System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String car_names = (br.readLine());
        //final String[] car_instance = car_names.split(",");
        String inputSentence = "car1,car2,car3,car4,car5";
        String racingCnt = "5";
        RacingCar racingCar = new RacingCar();
        racingCar.racingCar(inputSentence,racingCnt);

    }



}
