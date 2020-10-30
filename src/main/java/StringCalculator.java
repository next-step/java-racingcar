
public class StringCalculator {

    Context context;

    public StringCalculator() {
        this.context = new Context();
    }

    public Integer run(String input) {
        for (String rawToken : input.split(" ")) {
            Token token = new Token(rawToken);
            context.take(token);
        }

        return context.result;
    }
}
