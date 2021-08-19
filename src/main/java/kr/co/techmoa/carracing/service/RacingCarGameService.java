package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.model.CarName;
import kr.co.techmoa.carracing.model.Cars;
import kr.co.techmoa.carracing.service.move.RandomMoveStrategyImpl;
import kr.co.techmoa.carracing.ui.dto.InputDTO;
import kr.co.techmoa.carracing.ui.dto.OutputDTO;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameService {

    public OutputDTO start(InputDTO inputDTO) {
        String[] carNames = parseCarName(inputDTO.getCarNames());
        Cars cars = new Cars(carNames);

        List<RacingResults> results = new ArrayList<>();
        for (int i = 0; i < inputDTO.getTryNumber(); i++) {
            cars.roundOneTry();
            List<Car> resultOneTrial = cars.getCars();
            RacingResults result = new RacingResults(resultOneTrial);

            results.add(result);

        }


        System.out.println(results.get(0).getResults().get(0).getName() + " : " +results.get(0).getResults().get(0).getPosition());
        System.out.println(results.get(0).getResults().get(1).getName() + " : " +results.get(0).getResults().get(1).getPosition());
        System.out.println(results.get(0).getResults().get(2).getName() + " : " +results.get(0).getResults().get(2).getPosition());
        System.out.println("------");
        System.out.println(results.get(1).getResults().get(0).getName() + " : " +results.get(1).getResults().get(0).getPosition());
        System.out.println(results.get(1).getResults().get(1).getName() + " : " +results.get(1).getResults().get(1).getPosition());
        System.out.println(results.get(1).getResults().get(2).getName() + " : " +results.get(1).getResults().get(2).getPosition());
        System.out.println("------");
        System.out.println(results.get(2).getResults().get(0).getName() + " : " +results.get(2).getResults().get(0).getPosition());
        System.out.println(results.get(2).getResults().get(1).getName() + " : " +results.get(2).getResults().get(1).getPosition());
        System.out.println(results.get(2).getResults().get(2).getName() + " : " +results.get(2).getResults().get(2).getPosition());
        System.out.println("------");
        return new OutputDTO(results);
    }

    private String[] parseCarName(String carNames) {
        return carNames.split(",");
    }


}
