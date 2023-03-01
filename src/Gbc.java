import java.awt.*;

public class Gbc extends GridBagConstraints {
    Gbc(int x,int y){
        gridx=x;
        gridy=y;
        fill=BOTH;
        insets=new Insets(3,0,3,0);
    }
}
