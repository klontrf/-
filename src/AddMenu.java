import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class AddMenu extends JFrame implements ActionListener{
    IL il =new IL();
    ButtonGroup bg=new ButtonGroup();
    HashSet<Person> hs;
    String name,job,id,sex,mail,birth,tel;
    String ero;
    TextField f1,f2,f3,f4,f5,f6;

    JRadioButton j1,j2;

    MyButton mb1,mb2;
    AddMenu(HashSet<Person> hs){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.hs=hs;
        setSize(500,400);
        setTitle("添加人员");
        setLocation(400,150);
        setLayout(new FlowLayout(1));


        add(new MJLable("姓名："));
         f1=new TextField(7);
        add(f1);


        add(new MJLable("ID："));
         f2=new TextField(15);
        add(f2);

        add(new MJLable("                  "));
        add(new MJLable("电话："));
         f3=new TextField(19);
        add(f3);


        add(new MJLable("职务："));
        f6=new TextField(10);
        add(f6);
//        add(new MJLable("                              "));

        //为单选框添加事件监听器
        add ( new  MJLable("性别："));
         j1=new JRadioButton("男");
        add(j1);
         j2=new JRadioButton("女");
        add(j2);
//        jra1=new JRA();
//                ItemListener() {
//            ItemListener e;
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//
//            }
//        };
        j1.addItemListener(il);
        j2.addItemListener(il);
        bg.add(j1);
        bg.add(j2);
//        jra1.e.getSource()==


        add(new MJLable("邮箱："));
         f4=new TextField(20);
        add(f4);


        add(new MJLable("生日：（格式：yyyy-mm-dd）"));
         f5=new TextField(10);
        add(f5);

        add(new JLabel("                                                                                                                                       "));
//创建按钮
        mb1=new MyButton("创建人员");
        mb1.addActionListener(this);
        add(mb1);

        //返回上一级按钮
        mb2=new MyButton("返回上一级");
        mb2.addActionListener(this);
        add(mb2);
        setVisible(true);
    }
        boolean jiaoyan(){

        name= f1.getText();
        tel=f3.getText();
        id=f2.getText();
        mail= f4.getText();
        if(il.e==null)sex="";else
         sex= il.e.getSource()==j1?"男":"女";
        birth= f5.getText();
        job= f6.getText();
        if(name.equals("")||tel.equals("")||id.equals("")||mail.equals("")||sex.equals("")||birth.equals("")||job.equals("")){
            ero="信息不完整！";
            return false;
        }
        if(!MyVerify.checkTel(tel)){
            ero="号码格式有误";
            return false;
        }
        if(!MyVerify.checkMail(mail)){
            ero="邮箱格式有误";
            return false;
        }
        if(!MyVerify.checkDate(birth)){
            ero="出生日期格式有误";
            return false;
        }
        return true;
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mb1){
            if(jiaoyan()){
                if(!hs.add(new Person(name,tel,id,mail,sex,birth,job))){
                    new Information_pop_up(this,"Fail",true,"       ID已存在!");
                }else {
                    new AddMenu(hs);
                    this.dispose();
                    new Information_pop_up(this,"Success",true,"添加成功！");
                }

            }else {
                new Information_pop_up(this,"Error",true,ero);
            }
        }if(e.getSource()==mb2){
            new MainMenu(hs);
            this.dispose();
        }
    }
}
