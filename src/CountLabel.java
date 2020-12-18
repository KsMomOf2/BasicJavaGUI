import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CountLabel extends JLabel {

   private double start;
   private double time;
   private boolean countUp;
   private Timer timer;

   CountLabel(double start) {
      this(start, false, 1000);
   }

   CountLabel(double start, boolean countUp, int ms) {
      this.start = start;
      this.time = start;
      setText(String.format("%.2f", time));
      this.countUp = countUp;
      createTimer(ms);
   }

   private void createTimer(int ms) {
      timer = new Timer (ms, 
               
         new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent evt) {
               double seconds = ms / 1000.0;
               if(countUp) 
                  time += seconds;
               else
                  time -= seconds;
               setText(String.format("%.2f", time));
            }
         }
               );
      
   }

   public void start() {
      timer.start();
   }

   public void stop() {
      timer.stop();
   }
   
   public void resetCount() {
      time = start;
   }
}