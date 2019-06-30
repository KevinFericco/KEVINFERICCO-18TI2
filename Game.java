/*
 * kevin fericco/03082180025/18ti2
 */
package game;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Student
 */
public class Game extends JPanel implements KeyListener, ActionListener, Runnable {

    Font font = new Font("Verdana", Font.CENTER_BASELINE,14);
    static boolean right = false;
    static boolean left = false;
    
    int ballx = 160;
    int bally = 218;
    int batx = 160;
    int baty = 245;
    int brickx = 70;
    int bricky = 50;
    int score = 0 ;
    
    Rectangle Ball = new Rectangle(ballx, bally, 6, 6);
    Rectangle Bat = new Rectangle(batx, baty, 41, 6);
    Rectangle [] Brick = new Rectangle[12];
    
    Thread t;
    
    
public Game() {
    addKeyListener(this);
    setFocusable(true);
    t = new Thread(this);
    t.start();
    
 }

public static void main(String[] args){
    
    JFrame frame = new JFrame();
    Game game = new Game();
    JButton button = new JButton("Restart");
    frame.setSize(345, 320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    frame.add(game);
    
    
    frame.add(button, BorderLayout.SOUTH);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setVisible(true);
    button.addActionListener(game);
    
    
}

public void paint(Graphics g){
    
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(0, 0,350, 350);
    g.setColor(Color.RED);
    g.fillOval(Ball.x, Ball.y, Ball.width, Ball.height);
    g.setColor(Color.BLACK);
    g.fill3DRect(Bat.x,Bat.y,Bat.width,Bat.height, true);
    g.setColor(Color.GRAY);
    g.fillRect(0,251,450,200);
    g.setColor(Color.red);
    g.drawRect(0,0,338,250);
    g.setFont(font);
    g.setColor(Color.darkGray);
    g.drawString("Score : " +score, 100,12);
    g.setColor(Color.black);
    
    for (int i = 0; i < Brick.length; i++){
        if(Brick[i] != null){
            g.fill3DRect (Brick[i].x, Brick[i].y, Brick[i].width, Brick[i].height, true);
        }
    }
    if (ballFallDown == true || bricksOver == true){
        Font f = new Font("Verdana",Font.BOLD, 16);
        g.setColor(Color.WHITE);
        g.setFont(f);
        g.drawString(status, 115, 130);
        ballFallDown = false;
        bricksOver = false;
        
    }
    
    
}
    int movex = -1;
    int movey = -1;
    boolean ballFallDown = false;
    boolean bricksOver = false;
    String str = "";
    int count = 0;
    String status;
    
   
    public void run(){
        for (int i = 0; i<Brick.length; i++){
            Brick[i] = new Rectangle(brickx, bricky, 30,10);
            if (i == 5){
                brickx = 70;
                bricky = 62;
                
            }
            if (i == 9){
                brickx = 100;
                bricky = 74;
                
            }
            brickx += 31;
            
        }
        
        while(ballFallDown == false && bricksOver == false){
            for (int i = 0; i < Brick.length; i++){
                if (Brick[i] != null){
                    if(Brick[i].intersects(Ball)){
                        Brick[i] = null;
                        movey = -movey;
                        count++;
                        score  +=10;
                        
                }
            }
        }
            if (count == Brick.length){
                bricksOver = true;
                status = "YOU WIN !!!";
                repaint();
            }
            
            repaint();
            Ball.x += movex;
            Ball.y += movey;
            
            
            if (left == true){
                Bat.x -= 5;
                right = false;
            }
            
            if (right == true){
                Bat.x += 5;
                left = false;
            }
            
            if (Bat.x <= 4){
                Bat.x = 4;
                
            }
            else if(Bat.x >= 298){
                Bat.x = 298;
            }
            if (Ball.intersects(Bat)){
                movey = -movey;
                
            }
            if (Ball.x <= 0 || Ball.x + Ball.height >= 335){
                movex = -movex;
            }
            
            if (Ball.y <= 0){
                movey = -movey;
            }
            if(Ball.y >= 250){
                ballFallDown = true;
                status = "You Lose !! please Restart The Game";
                repaint();
            }
            try{
                Thread.sleep(8);
                
            }
            catch(Exception ex){
    }
}
    }
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT){
        left = true;
        }
        if (keyCode == KeyEvent.VK_RIGHT){
            right = true;
        }
       }
    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT){
            left = false;
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            right = false;
        }
    }
    public void keyTyped(KeyEvent arg0){
        
    }
    
    public void actionPerformed(ActionEvent e){
        String str = e.getActionCommand();
        if(str.equals("Restart")){
            this.Ulang();
        }
    }
    
    public void Ulang(){
        requestFocus(true);
        
        bally = 218;
        baty = 245;
        brickx = 70;
        bricky = 50;
        Ball = new Rectangle(ballx, bally, 6, 6);
        Bat = new Rectangle(batx, baty,41,6);
        Brick = new Rectangle[12];
        
        movex = -1;
        movey = -1;
        
        ballFallDown = false;
        bricksOver = false;
        
        count = 0;
        status = null;
        for (int i = 0; i< Brick.length; i++){
            Brick[i] = new Rectangle(brickx, bricky, 31, 11);
            
            if(i == 5){
                brickx = 70;
                bricky = 62;
                
            }
            if (i == 9){
                brickx = 100;
                bricky = 74;
            }
            brickx += 31;
        }
        repaint();
        
    }
}

