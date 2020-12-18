import javax.swing.JLabel;

public class ScoreLabel extends JLabel {

   private int score;

  ScoreLabel() {
    this(0);
  }

   ScoreLabel(int start) {
      setScore(start);
   }

   public int getScore() {
     return score;
   }

   public void setScore(int score) {
      this.score = score;
      setText("" + score);
   }
   
   public void increment() {
     score++;
     setText("" + score);
   }
   
   public void decrement() {
     score--;
     setText("" + score);
   }

}