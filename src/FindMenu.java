import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;

public class FindMenu extends JFrame implements ActionListener {
    HashSet<Person> hs;
    String txt;
    MyButton mb1=new MyButton("检索");
    MyButton mb2=new MyButton("返回上层");
    TextField tf=new TextField(17);
    FindMenu(HashSet<Person> hs){
        this.hs=hs;
        setLayout(new FlowLayout());
        setTitle("查找信息");
        setBounds(450,200,500,250);

        add(new MJLable("请输入关键字词："));

        add(tf);
        add(new JLabel("                                                                                                                         "));
        mb1.addActionListener(this);
        mb2.addActionListener(this);
        add(mb1);
        add(mb2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mb1){
            txt=tf.getText();
            if(txt.equals(""))new Information_pop_up(this,"Error",true,"输入为空!");
            else
            init();
        } else if (e.getSource()==mb2) {
            new MainMenu(hs);
            this.dispose();
        }
    }
    void init(){
        DisplayWin dw=new DisplayWin();
        dw.setTitle("检索结果");
        TextArea ta=new TextArea();
        ta.setEditable(false);
        ta.setFont(new Font("",1,15));
        dw.add(ta);
        Iterator<Person> it= hs.iterator();
        while (it.hasNext()){
            Person p=it.next();
            if(p.toString().indexOf(txt)!=-1){
                ta.append(p+"\n");
            }
        }
    }
}
