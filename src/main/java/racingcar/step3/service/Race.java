package racingcar.step3.service;

import racingcar.step3.domain.Car;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created : 2020-11-02 오전 8:22
 * Developer : Seo
 */
public class Race {
    public void run() {
        InputView iv = new InputView();
        ResultView rv = new ResultView();

        iv.setCars();
        iv.setTurns();

        System.out.println("\n실행 결과");
        for (int i = 1; i < iv.getTurns() + 1; i++) {
            start(iv);
            rv.printResult(iv);
            System.out.println("turn " + i + " 종료");
            System.out.println();
        }
    }

    public void start(InputView iv) {
        for (Car car : iv.getCars()) {
            try {
                if (SecureRandom.getInstanceStrong().nextInt(10) > 3) {
                    car.move();
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }
}
