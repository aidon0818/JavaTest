/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/12/9 17:11
 * Description .
 */
package JavaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0.0
 * CreateDate 2020/12/9 17:11
 * description
 * @Auther: liudong
 */
public class TwoListCopare {
    public static void main(String[] args) {
        UserDTO userOld1 = new UserDTO("1","aaa",22);
        UserDTO userOld2 = new UserDTO("2","bbb",32);
        UserDTO userOld3 = new UserDTO("3","ccc",11);
        UserDTO userOld4 = new UserDTO("4","ddd",42);
        UserDTO userOld5 = new UserDTO("5","bbb",22);
        UserDTO userOld6 = new UserDTO("6","eee",24);

        UserDTO userNew1 = new UserDTO("7","dada",22);     //新增一个
        UserDTO userNew2 = new UserDTO("2","bbb",32);     //不变一个
        UserDTO userNew3 = new UserDTO("3","kaka",33);     //更新一个
        UserDTO userNew4 = new UserDTO("8","dbdb",42);     //新增一个
        UserDTO userNew5 = new UserDTO("5","bbb",100);     //更新一个

        List<UserDTO> mapAdd = new ArrayList<>();


        List<UserDTO> oldList = new ArrayList<>();
        List<UserDTO> newList = new ArrayList<>();
        //添加老数据
        oldList.add(userOld1);
        oldList.add(userOld2);
        oldList.add(userOld3);
        oldList.add(userOld4);
        oldList.add(userOld5);
        oldList.add(userOld6);
        //添加新数据
        newList.add(userNew1);
        newList.add(userNew2);
        newList.add(userNew3);
        newList.add(userNew4);
        newList.add(userNew5);
        //去交集,既获取id相同的交集，需要更新
        //1.先提取出id和结果，用map形式
        List<String> oldIds = new ArrayList<>();
        List<String> newIds = new ArrayList<>();
        oldList.stream().forEach(it->oldIds.add(it.getId()));
        newList.stream().forEach(it->newIds.add(it.getId()));

        //取交集id
        System.out.println("-----------------交集----------------------");
        List<String> collectUpdate = newIds.stream().filter(it -> oldIds.contains(it)).collect(Collectors.toList());
        collectUpdate.stream().forEach(System.out::println);
        //取对应交集的对象
        System.out.println("------------------交集的对象---------------------");
        List<UserDTO> userUpdate = newList.stream().filter(it -> collectUpdate.contains(it.getId())).collect(Collectors.toList());
        userUpdate.stream().forEach(System.out::println);

        //取old的差集
        System.out.println("-----------------old的差集----------------------");
        List<String> collectDelete = oldIds.stream().filter(it -> !newIds.contains(it)).collect(Collectors.toList());
        collectDelete.stream().forEach((System.out::println));
        //取对应old差集对象
        System.out.println("-----------------old差集对象----------------------");
        List<UserDTO> userDelete = oldList.stream().filter(it -> collectDelete.contains(it.getId())).collect(Collectors.toList());
        userDelete.stream().forEach(System.out::println);

        //取new的差集
        System.out.println("-----------------new的差集----------------------");
        List<String> collectAdd = newIds.stream().filter(it -> !oldIds.contains(it)).collect(Collectors.toList());
        collectAdd.stream().forEach((System.out::println));
        //取对应old差集对象
        System.out.println("-------------------old差集对象--------------------");
        List<UserDTO> userAdd = newList.stream().filter(it -> collectAdd.contains(it.getId())).collect(Collectors.toList());
        userAdd.stream().forEach(System.out::println);


        //取并集
        System.out.println("-------------------并集--------------------");
        List<String> allIds = new ArrayList<>();
        //获取一个包含了oldIds和newIds的总结合,但是没有去重
        allIds.addAll(oldIds);
        allIds.addAll(newIds);
        //去重，获取并集ids的新集合
        List<String> joinIds = allIds.stream().distinct().collect(Collectors.toList());
        joinIds.stream().forEach(System.out::println);
    }
}