import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Layouts {

JFrame frame;
CountLabel countDown;
ScoreLabel score;

Layouts() {

  createFrame();
  frame.add(createPanel()); 
  frame.setVisible(true);
}
 
 private void createFrame() {
   frame = new JFrame();
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setLocationRelativeTo(null);
   frame.setSize(400,200);
}

private JPanel createPanel() {
  JPanel panel = new JPanel();
  panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
  panel.add(createCountDownPanel());
  panel.add(createScorePanel());
  return panel;
}

private JPanel createCountDownPanel() {
  JPanel panel = new JPanel();
  createCountDown();
  panel.add(countDown);
  panel.add(createStartButton());
  panel.add(createStopButton());
  return panel;
 }
 
private void createCountDown() {
  countDown = new CountLabel(25);
}

private JButton createStartButton() {
  JButton button = new JButton("Start");
  button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       countDown.start();
    }
    }
    );
    return button;
  }
  
private JButton createStopButton() {
  JButton button = new JButton("Stop");
  button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       countDown.stop();
    }
    }
    );
    return button;
  }
  
  private JPanel createScorePanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    score = new ScoreLabel();
    panel.add(score);
    panel.add(createUpButton());
    panel.add(createDownButton());
    return panel;
  }
  
  private JButton createUpButton() {
    JButton button = new JButton("Up");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        score.increment();
      }
    }
    );
    return button;
    }

  private JButton createDownButton() {
    JButton button = new JButton("Down");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        score.decrement();
      }
    }
    );
    return button;
    }
    }