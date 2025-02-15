// Sort hashmap by value.Example:Input: Map: {101=John Doe, 102=Jane Smith, 103=Peter Johnson}
//output: Map: {102=Jane Smith, 101=John Doe, 103=Peter Johnson} // 


import java.util.*;

public class SortHashMapByValue {
    public static void main(String[] args) {
        // Sample input HashMap
        Map<Integer, String> map = new HashMap<>();
        map.put(101, "John Doe");
        map.put(102, "Jane Smith");
        map.put(103, "Peter Johnson");

        // Sort by values
        Map<Integer, String> sortedMap = sortByValue(map);

        // Print the sorted map
        System.out.println(sortedMap);
    }

    public static Map<Integer, String> sortByValue(Map<Integer, String> map) {
        // Convert map to list of entries
        List<Map.Entry<Integer, String>> list = new ArrayList<>(map.entrySet());

        // Sort list by value (name)
        list.sort(Map.Entry.comparingByValue());

        // Create a LinkedHashMap to maintain order
        Map<Integer, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
