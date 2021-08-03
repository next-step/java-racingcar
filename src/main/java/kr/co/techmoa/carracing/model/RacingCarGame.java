package kr.co.techmoa.carracing.model;

import lombok.*;

import java.util.List;

@Getter
@Builder
public class RacingCarGame {

    private int carNum;
    private String carNames;
    private int tryNumber ;

    private List<Car[]> rounds;

}
