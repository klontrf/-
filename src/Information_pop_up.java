import javax.swing.*;
import java.awt.*;

public class Information_pop_up extends JDialog {
    Information_pop_up(Frame f, String title, boolean b){
        super(f,title,b);
        setSize(450,200);
        setLocation(450,200);
        setLayout(new GridLayout());
        Label a=new Label("The list of people is empty!Please enter the information first.");
        a.setFont(new Font("",0,15));
        add(a);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    Information_pop_up(Frame f, String title, boolean b, String txt){
        super(f,title,b);
        setSize(300,100);
        setLocation(450,200);
        setLayout(new GridLayout());
        MJLable a=new MJLable(txt);
        a.setFont(new Font("",0,15));
        add(a);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
