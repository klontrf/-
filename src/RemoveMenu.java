import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;

public class RemoveMenu extends JFrame implements ActionListener {
    HashSet hs;
    String txt;
    MyButton mb1=new MyButton("删除");
    MyButton mb2=new MyButton("返回上层");
    TextField tf=new TextField(17);
    Person p;
    RemoveMenu(HashSet<Person> hs){
        this.hs=hs;
        setLayout(new FlowLayout());
        setTitle("移除人员");
        setBounds(450,200,500,250);

        add(new MJLable("请输入被移除人ID："));

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
            else search();

        } else if (e.getSource()==mb2) {
            new MainMenu(hs);
            this.dispose();
        }
    }
    public void search(){
        boolean mark=true;
        Iterator<Person> it=hs.iterator();
        while (it.hasNext()){

            Person t;
            t=it.next();
            if (t.getId().equals(txt)){
                p=t;
                break;
            }
            if(!it.hasNext()){
                mark=false;
                new Information_pop_up(this,"未找到",true,"            该用户不存在！");
            }
        }
        if(mark){
            nextStep();
        }
    }
    public void nextStep(){
        hs.remove(p);

        RemoveMenu te= new RemoveMenu(hs);
        this.dispose();
        new Information_pop_up(te,"Success",true,"              删除成功！");
    }

}
