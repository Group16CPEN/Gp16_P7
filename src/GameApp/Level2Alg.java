package GameApp;

import java.util.ArrayList;

public class Level2Alg {
    public static int wordposition =0;
    public static ArrayList<words> L2Words;
    static int hint = 0;

    public static void levelstart() {
        DBAlg.getAllleveltwowords();
        L2Words = DBAlg.leveltwoarraylist;
        Level2.LetterScrambling(L2Words.get(0).getWord().toUpperCase());
    }
    public static void wordindexcheck() {
        if(wordposition == L2Words.size()-1) {
            Notification note = new Notification();
            note.CompletedLevel();
        }else {
            wordposition +=1;
            Level2.LetterScrambling(L2Words.get(wordposition).getWord().toUpperCase());
        }
    }

    public static String getCurrentWord() {
        return L2Words.get(wordposition).getWord();
    }

    public static String getHint() {
        if (hint==3){
            return "HINT LIMIT REACHED";
        }else {
            hint++;
        }
        return L2Words.get(wordposition).getHint().toUpperCase();
    }

}
