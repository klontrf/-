import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SortMenu extends JFrame implements ActionListener {


    HashSet<Person> hs;
    MyButton b1,b2,b3;
    SortMenu(HashSet<Person> hs){
        this.hs=hs;
        GridBagLayout gbl=new GridBagLayout();
        setLayout(gbl);
        this.setTitle("信息排序");
        this.setSize(400,300);
        this.setLocation(500,120);
        b1=new MyButton("依据ID从小到大排序");
        b2=new MyButton("依据姓名字典排序");
        b3=new MyButton("返回上一级");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        add(b1,new Gbc(0,0));
        add(b2,new Gbc(0,1));
        add(b3,new Gbc(0,2));
        this.setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            idSort();
        } else if (e.getSource()==b2) {
            nameSort();
        }else if(e.getSource()==b3){
            new MainMenu(hs);
            this.dispose();
        }
    }
    public void idSort(){
        TreeSet<Person> ts1=new TreeSet<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int num;
                num=p1.getId().compareTo(p2.getId());
                return num;
            }
        });
        Iterator<Person> it=hs.iterator();
        while (it.hasNext()){
            ts1.add(it.next());
        }
        DisplayWin dw=new DisplayWin();
        dw.setTitle("依据ID进行排序");
        TextArea ta=new TextArea();
        dw.add(ta);
        ta.setFont(new Font("",1,15));
        ta.setEditable(false);
        it=ts1.iterator();
        while (it.hasNext()){
            ta.append(it.next().toString()+"\n");
        }
    }
    public void nameSort(){
        TreeSet<Person> ts2=new TreeSet<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int num,num2;
                num=p1.getName().compareTo(p2.getName());
                num2=num==0?p1.getId().compareTo(p2.getId()):num;
                return num2;
            }
        });
        Iterator<Person> it=hs.iterator();
        while (it.hasNext()){
            ts2.add(it.next());
        }
        DisplayWin dw=new DisplayWin();
        dw.setTitle("依据姓名字典排序");
        TextArea ta=new TextArea();
        dw.add(ta);
        ta.setFont(new Font("",1,15));
        ta.setEditable(false);
        it=ts2.iterator();
        while (it.hasNext()){
            ta.append(it.next().toString()+"\n");
        }
    }
}
