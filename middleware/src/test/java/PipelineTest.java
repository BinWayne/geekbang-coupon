import java.io.BufferedReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PipelineTest {

    public static void main(String[] args) throws IOException {
        System.out.println("aa");

        //读取文件方式
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("/Users/wubin/workspace/geektime/springcloud/geekbang-coupon/middleware/target/classes/person.txt"));

        Stream<String> lines =bufferedReader.lines();
        List<Person> persons = lines.skip(1).map(line->{
            String[] arr = line.split(",");
            return new Person(Integer.parseInt(arr[3]),arr[1],arr[2],arr[4]);
        }).collect(Collectors.toList());

        persons.stream().forEach(System.out::println);


        System.out.println("--------");
        //对比
        for(Person p:persons){
            System.out.println(p);
        }
        System.out.println("--------");
        //对比2
        //将集合名单中包含的男性成员打印出来,删选用filter
        persons.stream().filter(p->p.getSex().equalsIgnoreCase("man")).forEach(System.out::println);

        //计算集合中所有男性成员的平均年龄；管道由 filter、mapToInt、average 组成
        double man = persons.stream()
                .filter(p -> p.getSex().equalsIgnoreCase("man"))
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println(man);

        //JDK 包含许多终端的操作（如 average， sum， min， max，和 count 通过组合一个流的内容返回一个值，在 java.util.stream.IntStream 中）
        //获取 所有男性 总值、
        int man1 = persons.stream().filter(p -> p.getSex().equalsIgnoreCase("man"))
                .mapToInt(Person::getAge)
                .sum();
        System.out.println(man1);

        //男性个数
        long man2 = persons.stream().filter(p -> p.getSex().equalsIgnoreCase("man")).count();
        System.out.println(man2);
        //找出男性年纪最大
        Optional<Person> man3 = persons.stream().filter(p -> p.getSex().equalsIgnoreCase("man")).max(Comparator.comparing(Person::getAge));
        Person p = man3.get();
        System.out.println(p);

        System.out.println("-------");
        //先按年龄排序 再按 名字排序
        List<Person> collect = persons.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getFirstName))
                .collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
        System.out.println("-----");



    }
}
