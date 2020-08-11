package command;

import java.util.function.Function;
import java.util.function.Supplier;

public enum Command {
    GO{
      public void execute() { System.out.print("-"); }
    },
    STOP{
        public void execute() { System.out.println(""); }
    };

    abstract public void execute();

}
