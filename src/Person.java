import java.util.Objects;

public class Person {
    private String name,tel,id,mail,sex,birth,job;


    public Person(){}

    public Person(String name, String tel, String id, String mail, String sex, String birth, String job) {
        this.name = name;
        this.tel = tel;
        this.id = id;
        this.mail = mail;
        this.sex = sex;
        this.birth = birth;
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", id='" + id + '\'' +
                ", mail='" + mail + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
