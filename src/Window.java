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
                    int res1 = JOptionPane.showConfirmDialog(Window.this,"Устраивает" +
                            " ли вас ваша работа?", "Жоб1",JOptionPane.YES_NO_OPTION);
                    if(res1 == JOptionPane.YES_OPTION){
                       JOptionPane.showMessageDialog(Window.this,"Очень рад за вас",
                               "Жоб1",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(Window.this,"Удачи с поиском новой",
                                "Жоб1",JOptionPane.INFORMATION_MESSAGE);
                    }

                    int res2 = JOptionPane.showConfirmDialog(Window.this,"Хотите ли поменять" +
                            " работу?", "Жоб2",JOptionPane.YES_NO_OPTION);
                    if(res2 == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(Window.this,"Очень ответственный шаг",
                                "Жоб2",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(Window.this,"Ну бб тогда",
                                "Жоб2",JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            }
        });

        frame.setVisible(true);
        frame.pack();
    }
}
