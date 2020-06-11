package GameApp;


import javafx.stage.Stage;
import java.util.ArrayList;

public class Level1Alg {
    public static int wordposition;
    public static ArrayList<words> L1Words;
    static int hint =0;

    public static void levelstart() {
        DBAlg.getAlllevelonewords();
        L1Words =DBAlg.levelonearraylist;
        Level1.LetterScrambling(L1Words.get(0).getWord());
    }
    public static void wordindexcheck() {
        if(wordposition == L1Words.size()-1) {
          Notification notification = new Notification();
          notification.CompletedLevel();
        } else {
            wordposition +=1;
            Level1.LetterScrambling(L1Words.get(wordposition).getWord());
        }
    }
    public static String getCurrentWord() {
       return L1Words.get(wordposition).getWord();
    }
public static String getHint(){
        if (hint==3){
            return "HINT LIMIT REACHED";
        }else {
            hint++;
        }
        return L1Words.get(wordposition).getHint();
      }
}

