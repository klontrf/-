import java.text.SimpleDateFormat;

public class MyVerify {
    public static boolean checkDate(String date) {
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");//括号内为日期格式，y代表年份，M代表年份中的月份（为避免与小时中的分钟数m冲突，此处用M），d代表月份中的天数
        try {
            sd.setLenient(false);//此处指定日期/时间解析是否不严格，在true是不严格，false时为严格
            sd.parse(date);//从给定字符串的开始解析文本，以生成一个日期
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    public static boolean checkTel(String tel){
        return tel.matches("^1[3-9]\\d{9}$");
    }
    public static boolean checkMail(String mail){
        return mail.matches("^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$");
    }
}
