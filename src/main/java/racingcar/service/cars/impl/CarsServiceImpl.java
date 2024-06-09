package racingcar.service.cars.impl;

import racingcar.service.cars.CarsService;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarsServiceImpl implements CarsService {
    private final InputView inputView;
    private static final int LIMIT_NAME_LENGTH = 5;

    public CarsServiceImpl(InputView inputView) {
        this.inputView = inputView;
    }

    public List<String> getCarsName(){
        Scanner scanner = new Scanner(System.in);
        List<String> carsNameList;
        while(true){
            try{
                String carsName = inputView.inputString();
                carsNameList = splitCarsNmae(carsName);
                checkCarsName(carsNameList);
                break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 이름은 5자를 넘길 수 없습니다.");
            }
        }
        return carsNameList;
    }

    private List<String> splitCarsNmae(String carsName){
        if(carsName.isEmpty()) throw new IllegalArgumentException("이름을 입력하세요");

        return Arrays.stream(carsName.split(","))
                     .collect(Collectors.toList());
    }
    private void checkCarsName(List<String> carsNameList){
        if (carsNameList.stream().anyMatch(name -> name.length() > LIMIT_NAME_LENGTH)) {
            throw new IllegalArgumentException("이름은 5자를 넘길 수 없습니다.");
        }
    }


}
