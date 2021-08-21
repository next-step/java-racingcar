package kr.co.techmoa.carracing.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Move {

    ADVANCE(true , "전진"),
    REVERSE(false , "후진"),
;

    private final boolean carMove;
    private final String discription;
}
