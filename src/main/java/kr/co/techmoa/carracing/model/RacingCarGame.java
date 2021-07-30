package kr.co.techmoa.carracing.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class RacingCarGame {

    private int carNum;
    private int tryNumber ;

    private List<Car[]> rounds;

}
