package custmoerSpends;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerSpendsMain {
    public static void main(String[] args) {

        List<CustomerSpends> list = List.of(
                new CustomerSpends("Alice", 120.0),
                new CustomerSpends("Bob", 300.0),
                new CustomerSpends("Charlie", 150.0),
                new CustomerSpends("Alice", 180.0),
                new CustomerSpends("Bob", 220.0),
                new CustomerSpends("David", 90.0)

        );

        Map<String, Double> map = list.stream().collect(Collectors.groupingBy(CustomerSpends::getCustomer, Collectors.summingDouble(CustomerSpends::getAmount)));

        //top 3 customers by spend

        map.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).limit(3).forEach(i -> System.out.println(i.getKey() + ": " + i.getValue()));

    }
}
