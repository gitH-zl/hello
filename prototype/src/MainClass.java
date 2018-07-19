import java.util.ArrayList;
import java.util.List;

/**
 * @author ZL
 * @date 2018/6/24 16:44
 */
/*原型模式*/
//浅克隆；对象的引用指向同一个地址，如例子中的List
// 和深克隆：对象中的引用指向不同的地址，
public class MainClass {

    public static void main(String[] args) {

        Person person1 = new Person();
        person1.setName("zl");
        person1.setAge(12);
        person1.setSex("男");
        //Person person2 = new Person()创建对象 但地址相同，指向同一个地址
        Person person2 = person1.clone();//创建对象 但地址不同，指向不同的地址。
        List<String> friends= new ArrayList<String>();
        friends.add("张良");
        friends.add("张锐");
        person1.setFriends(friends);
        person2=person1.clone();
        System.out.println(person1.getFriends());
        System.out.println(person2.getFriends());
        System.out.println("qqqqqq");
    }

}
