package exercise;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildAppartmentsList(List<Home> list, int n) {
       return list.stream()
               .sorted(Comparator.comparing(Home::getArea))
               .map(Object::toString)
               .limit(n)
               .collect(Collectors.toList());
    }
}
// END
