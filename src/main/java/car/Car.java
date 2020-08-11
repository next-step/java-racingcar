package car;

import command.Command;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private List<Command> commandList;

    public Car(List<Command> list) {
        this.commandList = list;
    }


}
