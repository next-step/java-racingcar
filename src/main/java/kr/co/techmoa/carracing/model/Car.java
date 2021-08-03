package kr.co.techmoa.carracing.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class Car {

    private int move;
    private int totalMove;
    private String carName;

}
