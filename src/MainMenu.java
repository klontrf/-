import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class MainMenu extends JFrame implements ActionListener {
    JMenuBar bar=new JMenuBar();
    JMenu about=new JMenu("关于");
    JMenuItem me=new JMenuItem("我");
    private MyButton b1,b2,b3,b4,b5,b6;
    HashSet<Person> hs;
    public MainMenu(HashSet<Person> hs){
        this.hs=hs;
        GridBagLayout gbl=new GridBagLayout();
        setLayout(gbl);
        this.setTitle("人事管理系统");
        this.setSize(400,680);
        this.setLocation(500,20);
        initJmenu();
        b1=new MyButton("添加人员");
        add(b1,new Gbc(0,0));
        b2=new MyButton("查找信息");
        add(b2,new Gbc(0,1));
        b3=new MyButton("修改信息");
        add(b3,new Gbc(0,2));
        b4=new MyButton("移除人员");
        add(b4,new Gbc(0,3));
        b5=new MyButton("信息排序");
        add(b5,new Gbc(0,4));
        b6=new MyButton("退出程序");
        add(b6,new Gbc(0,5));
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        this.setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    void initJmenu(){
        me.addActionListener(this);
        bar.add(about);
        about.add(me);
        setJMenuBar(bar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new AddMenu(hs);
            this.dispose();
        } else if (e.getSource()==b2) {
            if(hs.isEmpty()){
                new Information_pop_up(this,"Error",true);
            }else{
                new FindMenu(hs);
                this.dispose();
            }
        } else if (e.getSource()==b3) {
            if(hs.isEmpty()){
                new Information_pop_up(this,"Error",true);
            }else{
                new ReviseMenu1(hs);
                this.dispose();
            }

        }else if(e.getSource()==b4){
            if(hs.isEmpty()){
                new Information_pop_up(this,"Error",true);
            }else
            {
                new RemoveMenu(hs);
                this.dispose();
            }

        }else if(e.getSource()==b5){
            if(hs.isEmpty()){
                new Information_pop_up(this,"Error",true);
            }else
            {
                new SortMenu(hs);
                this.dispose();
            }

        }else if(e.getSource()==b6){
            this.dispose();
            System.exit(0);
        } else if (e.getSource()==me) {
            new Information_pop_up(this,"关于作者",true,"关于作者：\n软件学院21级苏康214804285");
        }
    }
}
