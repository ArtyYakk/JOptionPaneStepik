import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window extends JFrame {

    public void run(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,800));
        frame.setLocation(-5,0);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if(e.getKeyCode() == 32){
                    JOptionPane.showMessageDialog(Window.this,
                            "<html><h2>Артём</h2><i>моё имя</i>");
                }
            }
        });

        frame.setVisible(true);
        frame.pack();
    }
}
