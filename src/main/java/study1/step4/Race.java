package study1.step4;

public class Race {

    public void race(){
        String racerListString = InputView.getRacerList();
        Tokenizer tokenizer = new Tokenizer();

        tokenizer.TokenListValidate(racerListString);
        String[] racerList = tokenizer.getList(racerListString);

        int dummy = 1;
    }
}
