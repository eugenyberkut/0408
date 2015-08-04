package logic;

/**
 * Created by Yevhen on 04.08.2015.
 */
public class Person {
    private String name;
    private int zp;
    private String phone;

    public Person(String name, int zp, String phone) {
        this.name = name;
        this.zp = zp;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZp() {
        return zp;
    }

    public void setZp(int zp) {
        this.zp = zp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", zp=" + zp +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (zp != person.zp) return false;
        if (!name.equals(person.name)) return false;
        return !(phone != null ? !phone.equals(person.phone) : person.phone != null);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + zp;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
