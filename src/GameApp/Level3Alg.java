package GameApp;

import java.util.ArrayList;

public class Level3Alg {
    public static int wordposition = 0;
    public static  ArrayList<words> L3words;
    static int hint = 0;

    public static void levelstart() {
        DBAlg.getAlllevelthreewords();
        L3words = DBAlg.levelthreearraylist;
        Level3.LetterScrambling(L3words.get(0).getWord());
    }
    public static void wordindexcheck() {
        if(wordposition == L3words.size()-1) {
            Notification note = new Notification();
            note.CompletedLevel();
        }else {
            wordposition +=1;
            Level3.LetterScrambling(L3words.get(wordposition).getWord());
        }
    }

    public static String getCurrentWord() {
        return L3words.get(wordposition).getWord();
    }

    public static String getHint() {
        if (hint==3){
            return "HINT LIMIT REACHED";
        }else {
            hint++;
        }
        return L3words.get(wordposition).getHint().toUpperCase();
    }
}
