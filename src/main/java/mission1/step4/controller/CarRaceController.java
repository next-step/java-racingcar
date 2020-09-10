package mission1.step4.controller;

import mission1.step4.CarRace;
import mission1.step4.domain.car.Car;
import mission1.step4.domain.car.CarEntry;
import mission1.step4.view.InputView;
import mission1.step4.view.RenderView;

import java.util.Arrays;
import java.util.Scanner;

public class CarRaceController {
    public static void run() {
        InputView inputView = new InputView();
        inputView.run();

        // 자동차 엔트리 생성
        CarEntry carEntry = new CarEntry();
        // 엔트리에 자동차 등록
        Arrays.asList(inputView.getCarNameList().split(","))
                    .forEach((carName) -> carEntry.regist(Car.create(carName)));
        // 자동차 레이스 생성, 엔트리 등록
        CarRace carRace = CarRace.getInstance(carEntry);

        System.out.println("실행결과");
        //경기 시작
        for (int i = 0; i < inputView.getExecNum(); i++) {
            RenderView.showCarProgress(carRace.start());
        }
        RenderView.showRaceWinner(carEntry.getRaceWinner());
    }
}


