import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    public MyButton(String text){
        super(text);
        setFont(new Font("",1,20));
        setFocusPainted(false);
    }

}