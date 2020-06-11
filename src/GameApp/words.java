package GameApp;

public class words {
    private String word;
    private String hint;

    public words(String word, String hint, int level, int id) {
        super();
        this.word = word;
        this.hint = hint;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String getHint() {
        return hint;
    }
}
