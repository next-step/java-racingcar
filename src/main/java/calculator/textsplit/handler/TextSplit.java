package calculator.textsplit.handler;

import calculator.textsplit.InputText;

public abstract class TextSplit {
    private TextSplit next;
    protected final InputText text;

    public TextSplit(InputText text) {
        this.text = text;
    }

    public TextSplit setNext(TextSplit next) {
        this.next = next;
        return next;
    }

    public void split() {
        if (resolve()) {
            done();
            return;
        }
        if (next != null) {
            next.split();
        }
    }

    protected abstract boolean resolve();

    protected abstract void done();
}
