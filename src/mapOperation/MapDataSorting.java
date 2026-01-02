package mapOperation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapDataSorting {

    public static void main(String[] args) {
      Map<String, Integer> map = new HashMap<>();
      map.put("apple", 3);
      map.put("banana", 1);
      map.put("orange", 2);
      map.put("grape", 5);
      map.put("kiwi", 4);

     Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).
              collect(Collectors.toMap(Map.Entry::getKey,
                      Map.Entry::getValue,
                      (e1,e2)->e1,
                      LinkedHashMap::new));

     sortedMap.forEach((key, value) -> System.out.println(key + ": " + value));


    }
}
