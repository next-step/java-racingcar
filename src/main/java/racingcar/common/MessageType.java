package racingcar.common;

import java.util.function.Function;

public enum MessageType {
    INFO(msg -> "[ " + msg + " ]") ,
    EMPTY(msg -> "") ,
    GAME (msg -> "게임 :: " +msg );

    Function<String , String> expression;

    MessageType(Function <String , String> express) {
        this.expression = express;
    }

    public String message(String msg){
        return expression.apply(msg);
    }
}
