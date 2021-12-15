import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscapeRoom {
    static boolean havecandle, havedynamite;
    static JLabel setting;
    static JPanel panel;
    static JButton Bed, painting, wall, candle, Drawer, BehindPainting, turnBack, arson, BOOM, restarrt;
    public static void main(String[] args) {
        setting = new JLabel("you awaken in a dimly lit room. you can see a wax candle burning in the middle, a bed on the left  with a nighstand next to it, and a painting on the wall to the right. straight ahead you notice a small crack in the wall.");
        JFrame frame = new JFrame("escape room");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        panel = new JPanel();
        Bed = new JButton("go to the bed");
        painting = new JButton("Check out painting");
        wall = new JButton("look at cracked wall");
        candle = new JButton("pick up candle");
        arson = new JButton("set bed on fire");
        Drawer = new JButton("open drawer");
        turnBack=new JButton("turn back");
        BOOM= new JButton("BLOW UP DA WALL");
        restarrt= new JButton("retry");
        BehindPainting= new JButton("check behind painting");
        panel.setBackground(Color.WHITE);
        frame.add(panel);
        panel.add(setting);
        panel.add(Bed);
        panel.add(candle);
        panel.add(wall);
        panel.add(painting);
        frame.setVisible(true);
        havecandle=false;
        havedynamite=false;

        havecandle = false;
        Bed.addActionListener(new BedListener());
        painting.addActionListener(new paintingListener());
        turnBack.addActionListener(new goBack());
        BehindPainting.addActionListener(new CheckPaint());
        candle.addActionListener(new CandleListener());
        arson.addActionListener(new fire());
        Drawer.addActionListener(new drawerr());
        restarrt.addActionListener(new retry());
        wall.addActionListener(new walll());
        BOOM.addActionListener(new EXPLODE());




    }
private static class BedListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setting.setText("You walk over to the bed and see a drawer on the nightstand and about a foot of space between the bed and the floor");
        panel.remove(Bed);
        panel.remove(candle);
        panel.remove(wall);
        panel.remove(painting);
        panel.add(turnBack);
        panel.add(Drawer);
        if (havecandle = true){
            panel.add(arson);
        }
        panel.updateUI();
    }
}


private static class paintingListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setting.setText("The painting is just a void of different shades of black and grey");
       panel.remove(Bed);
       panel.remove(painting);
       panel.remove(candle);
       panel.remove(wall);
        panel.add(turnBack);
        panel.add(BehindPainting);
        panel.updateUI();
    }
}
private static class goBack implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setting.setText("youre back in the middle of the room");
        panel.remove(Drawer);
        panel.remove(turnBack);
        panel.remove(Drawer);
        panel.remove(arson);
        panel.add(Bed);
        panel.add(candle);
        panel.add(wall);
        panel.add(painting);
        panel.updateUI();
    }
}
private static class CandleListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setting.setText("you have obtained a candle");
        panel.remove(Bed);
        panel.remove(painting);
        panel.remove(candle);
        panel.remove(wall);
        panel.add(turnBack);
        havecandle = true;
        panel.updateUI();
    }
}
private static class CheckPaint implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setting.setText("you find nothing. weird. theres always something behind the painting");
        panel.remove(BehindPainting);
        panel.add(turnBack);
        panel.updateUI();
    }
}
private static class fire implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       setting.setText("the bed is now on fire...why would you do that");
       panel.remove(Drawer);
       panel.add(turnBack);
       panel.updateUI();
    }
}
private static class drawerr implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setting.setText("you have obtained a bundle of dynamite");
        panel.remove(Drawer);
        panel.add(turnBack);
        havedynamite=true;
        panel.updateUI();
    }
}
private  static  class  walll implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setting.setText("The wall looks like itd break with enough force");
        panel.remove(Bed);
        panel.remove(painting);
        panel.remove(candle);
        panel.remove(wall);
        panel.add(turnBack);
        if (havedynamite && havecandle == true){
            panel.add(BOOM);
            panel.updateUI();
        }
    }
}
private static class EXPLODE implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setting.setText("the dynamite ignite and you go back to the far wall. the shock waves bounce off the walls of the small room and you pass away due to multiple ruptured organs");
        panel.remove(BOOM);
        panel.remove(turnBack);
        panel.add(restarrt);
        panel.updateUI();
    }
}
private static class retry implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setting.setText("you awaken in a dimly lit room. you can see a wax candle burning in the middle, a bed on the left  with a nighstand next to it, and a painting on the wall to the right. straight ahead you notice a small crack in the wall.");
        panel.add(setting);
        panel.add(Bed);
        panel.add(candle);
        panel.add(wall);
        panel.add(painting);
        panel.remove(restarrt);
        panel.updateUI();

    }
}
}
