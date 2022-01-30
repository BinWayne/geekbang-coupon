import java.io.BufferedReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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

    }
}
