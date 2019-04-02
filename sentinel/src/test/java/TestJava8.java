import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestJava8 {
    public static void main(String[] args) {
        //声明一个List集合

        List<Person> list = TestJava8.getList();
//        list.parallelStream().forEach(vo->{
//            System.out.println(vo.getName());
//        });
    }

    public static List<Person> getList(){
        List<Person> list = new ArrayList();
        list.add(new Person("1001", "小A"));
        list.add(new Person("1002", "小B"));
        list.add(new Person("1003", "小C"));
        list.add(new Person("1003", "小D"));
        list.add(new Person("1003", "小E"));
        list.add(new Person("1003", "小E"));
        list.add(new Person("1003", "小E"));
        list.add(new Person("1003", "小E"));
        list.add(new Person("1003", "小E"));
        list.add(new Person("1003", "小E"));
        list.add(new Person("1003", "小E"));
//        System.out.println(list);
//        list.stream().collect(Collectors.toMap(Person::getId, Person::getName));
//        Map<String, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName));
//        map.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
//        System.out.println(map);
        list.forEach(vo->{
            System.out.println(vo.getName());
        });
        System.out.println("ssssss");
        return list;
    }

    public static class Person {
        private String id;
        private String name;

        public Person(String id, String name) {
            this.id = id;
            this.name = name;
        }

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
    }

}
