import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.regex.Pattern;

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
                if((e.getKeyCode() == 32)&&(e.isShiftDown())){
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

        String login = "";
        int loginChars = 0;
        boolean loginHasSpaces = true;

        int wantReg = JOptionPane.showConfirmDialog(Window.this,"Здравствуйте, хотите ли " +
                "зарегистрироваться?","Регистрация", JOptionPane.YES_NO_OPTION);
        if (wantReg == JOptionPane.YES_OPTION){
            while((loginChars < 5)||(loginHasSpaces)){
                 login = JOptionPane.showInputDialog(Window.this, "Ведите " +
                        "логин", "Логин", JOptionPane.QUESTION_MESSAGE);
                 if(login != null){
                     loginChars = login.length();
                     loginHasSpaces = Arrays.stream(login.split("")).anyMatch(a -> a.contains(" "));

                     String password = "";
                     int passwordChars = 0;
                     boolean passwordHasSpaces = true;
                     boolean passwordHasLetter = false;
                     boolean passwordHasDigit = false;


                     while((passwordChars < 8)||(!passwordHasDigit)||(!passwordHasLetter)||(passwordHasSpaces)){

                         JPanel passPanel = new JPanel();
                         JLabel passLabel = new JLabel("Enter a password");
                         JPasswordField pass = new JPasswordField(10);
                         passPanel.add(passLabel);
                         passPanel.add(pass);
                         String[] passOptions = new String[]{"OK","Cancel"};
                         int passOption = JOptionPane.showOptionDialog(null,passPanel,"Ввод пароля",
                                 JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, passOptions,passOptions[0]);
                         System.out.println(passOption);
                         if(passOption == 0){
                             char[] passw = pass.getPassword();
                             password = String.valueOf(passw);
                             if(password.equals("")) continue;
                         } else break;

                         passwordChars = password.length();
                         passwordHasSpaces = Arrays.stream(password.split("")).anyMatch(a -> a.contains(" "));
                         passwordHasLetter = Arrays.stream(password.split("")).map(a -> a.charAt(0)).
                                 anyMatch(Character::isLetter);
                         passwordHasDigit = Arrays.stream(password.split("")).map(a -> a.charAt(0)).
                                 anyMatch(Character::isDigit);
                     }

                     if(!password.equals("")){
                         String secPassword = "";
                         while (!secPassword.equals(password)){
                             /////
                             JPanel secPassPanel = new JPanel();
                             JLabel secPassLabel = new JLabel("Enter a password again");
                             JPasswordField secPass = new JPasswordField(10);
                             secPassPanel.add(secPassLabel);
                             secPassPanel.add(secPass);
                             String[] passOptions = new String[]{"OK","Cancel"};
                             int secPassOption = JOptionPane.showOptionDialog(null,secPassPanel,"Подтверждение пароля",
                                     JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, passOptions,passOptions[0]);
                             if(secPassOption == 0){
                                 char[] passw = secPass.getPassword();
                                 secPassword = String.valueOf(passw);
                             } else break;
                             ////
                         }
                         if(!secPassword.equals("")) JOptionPane.showMessageDialog(Window.this,"Вы успешно зарегистрированы",
                                 "Регистрация завершена",JOptionPane.INFORMATION_MESSAGE);
                     }

                 } else break;
            }


        }


    }
}
