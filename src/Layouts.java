import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import javax.swing.Timer;

public class Layouts extends JFrame implements KeyListener {
   private final static int GAME_WIDTH = 700, GAME_HEIGHT = 500;
   
   private CountLabel countDown;
   private ScoreLabel score;
   private GamePanel gamePanel;
   
   private boolean gameActive;
   Layouts() {
      gameActive = false;
      createFrame();
      add(createPanel(), BorderLayout.PAGE_START);   
      gamePanel = new GamePanel();   
      add(gamePanel, BorderLayout.CENTER);
      
      setVisible(true);
      requestFocus();
   }
   
   private void createFrame() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocation(25,20);
      setSize(GAME_WIDTH,GAME_HEIGHT);
      addKeyListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);
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
      button.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               gamePanel.startMove();
               countDown.start();
               gameActive = true;
               requestFocus();// When the user presses the button, the keylistener stops working, this line fixes that
            }
         }
         );
      return button;
   }
  
   private JButton createStopButton() {
      JButton button = new JButton("Stop");
      button.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               gamePanel.stop();
               countDown.stop();
               gameActive = false;
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
      button.addActionListener(
         new ActionListener() {
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
      button.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               score.decrement();
            }
         }
         );
      return button;
   }
    
   public void keyReleased(KeyEvent e) {
   }
   public void keyPressed(KeyEvent e) {
      if (! gameActive)
        return;
        
      char ch = e.getKeyChar();
      System.out.println(ch);
      int code = e.getKeyCode();
      
      switch(code) {
         case KeyEvent.VK_UP : System.out.println("Up"); 
            break;
         case KeyEvent.VK_DOWN: System.out.println("Down"); 
            break;      
         case KeyEvent.VK_LEFT: System.out.println("Left"); 
            break;
         case KeyEvent.VK_RIGHT: System.out.println("Right"); 
            break;
         case KeyEvent.VK_S : gamePanel.jumpDown(); break;
         case KeyEvent.VK_SPACE: System.out.println("Space");
         case KeyEvent.VK_W: 
           gamePanel.jumpUp();
           break;
      }
   }
   public void keyTyped(KeyEvent e) {
   }
}