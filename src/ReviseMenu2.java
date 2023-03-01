import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class ReviseMenu2 extends JFrame implements ActionListener {
    IL il =new IL();
    ButtonGroup bg=new ButtonGroup();
    HashSet<Person> hs;
    String name,job,id,sex,mail,birth,tel;
    String ero;
    TextField f1,f2,f3,f4,f5,f6;
    Person p;
    JRadioButton j1,j2;

    MyButton mb1,mb2;
    ReviseMenu2(HashSet<Person> hs,Person p){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.hs=hs;
        this.p=p;
        setSize(500,400);
        setTitle("修改信息");
        setLocation(400,150);
        setLayout(new FlowLayout(1));


        add(new MJLable("姓名："));
        f1=new TextField(7);
        f1.setText(p.getName());
        add(f1);


        add(new MJLable("ID："));
        f2=new TextField(15);
        f2.setEditable(false);
        f2.setText(p.getId());
        add(f2);

        add(new MJLable("                  "));
        add(new MJLable("电话："));
        f3=new TextField(19);
        f3.setText(p.getTel());
        add(f3);


        add(new MJLable("职务："));
        f6=new TextField(10);
        f6.setText(p.getJob());
        add(f6);
//        add(new MJLable("                              "));

        //为单选框添加事件监听器
        add ( new  MJLable("性别："));
        j1=new JRadioButton("男");
        add(j1);
        j2=new JRadioButton("女");
        add(j2);

        j1.addItemListener(il);
        j2.addItemListener(il);
        bg.add(j1);
        bg.add(j2);
        if(p.getSex().equals("男")){
            j1.setSelected(true);
        }else {
            j2.setSelected(true);
        }
//        jra1.e.getSource()==


        add(new MJLable("邮箱："));
        f4=new TextField(20);
        f4.setText(p.getMail());
        add(f4);


        add(new MJLable("生日：（格式：yyyy-mm-dd）"));
        f5=new TextField(10);
        f5.setText(p.getBirth());
        add(f5);

        add(new JLabel("                                                                                                                                       "));
//创建按钮
        mb1=new MyButton("完成修改");
        mb1.addActionListener(this);
        add(mb1);

        //返回上一级按钮
        mb2=new MyButton("返回上一级");
        mb2.addActionListener(this);
        add(mb2);
        add(new MJLable("（ID作为身份识别的唯一标识不可修改）"));
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
                revise();
                  ReviseMenu1 te=  new ReviseMenu1(hs);

                this.dispose();
                new Information_pop_up(te,"Success",true,"          修改成功！");
            }else {
                new Information_pop_up(this,"Error",true,ero);
            }
        }if(e.getSource()==mb2){
            new ReviseMenu1(hs);
            this.dispose();
        }
    }
    void revise(){
        p.setName(f1.getText());
        p.setBirth(f5.getText());
        p.setJob(f6.getText());
        p.setMail(f4.getText());
        p.setTel(f3.getText());
        p.setSex(il.e.getSource()==j1?"男":"女");
    }
}
