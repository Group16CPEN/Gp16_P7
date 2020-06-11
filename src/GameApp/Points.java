package GameApp;

public class Points {
    static int points=0;
    public static void Point() {
        points+=3;
        if(points<10) {
           Level1.score.setText(""+points+"");
        }else {
            Level1.score.setText(points+"");
        }
    }
    public static void Points2() {
        points+=3;
        if(points<10) {
            Level2.score.setText(""+points+"");
        }else {
            Level2.score.setText(points+"");
        }
    }
    public static void Points3() {
        points+=3;
        if(points<10) {
            Level3.score.setText(""+points+"");
        }else {
            Level3.score.setText(points+"");
        }
    }
}
