/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/12/9 17:09
 * Description .
 */
package JavaTest;

/**
 * @version 1.0.0
 * CreateDate 2020/12/9 17:09
 * description
 * @Auther: liudong
 */

public class UserDTO {
    private String id;
    private String name;
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserDTO(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}