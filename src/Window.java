import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class Window extends JFrame {
    String[] resolution = new String[]{  "800x600",
                                         "1024x768",
                                         "1200x600",
                                         "1280x1024",
                                         "1680x1050",
                                         "1920x1080"};

    public void run(){
        String dimen = (String) JOptionPane.showInputDialog(Window.this,"Выберите разрешение",
                "выбор разрешения",JOptionPane.QUESTION_MESSAGE,null,resolution,
                resolution[0]);
        int[] kords = Arrays.stream(dimen.split("x")).mapToInt(Integer::valueOf).toArray();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(kords[0],kords[1]));
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
