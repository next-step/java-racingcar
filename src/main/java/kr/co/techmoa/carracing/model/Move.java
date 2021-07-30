package kr.co.techmoa.carracing.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Move {

    ADVANCE(1 , "전진"),
    REVERSE(0 , "후진"),
;

    private final int carMove;
    private final String discription;
}
