package kr.co.techmoa.carracing.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Car {

    private int move;
    private int totalMove;
    private String carName;

    @Builder.Default
    private boolean isWin = false;

}
