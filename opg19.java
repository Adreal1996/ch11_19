package ch11;

/* Write a method called rarest that accepts a map whose keys are strings and whose values are integers
as a parameter and returns the integer value that occurs the fewest times in the map.
If there is a tie, return the smaller integer value. If the map is empty, throw an exception. */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class opg19
{

        public static void main(String[] args)
        {


            Map<String, Integer> map = new HashMap<>();

            map.put("nr1", 1);
            map.put("nr3", 3);
            map.put("nr5", 5);
            map.put("nr7", 7);
            map.put("nr3", 3);
            map.put("nr7", 7);

            System.out.println("The value that appear fewer times are....... Badum tsh: " + rarest(map));

        }

    public static int rarest (Map<String, Integer> map) {

        Map<Integer, Integer> tempMap = new HashMap<>();
        // Note til mig selv - Map: https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int num = map.get(entry.getKey());
            if (tempMap.containsKey(num)) {
                tempMap.put(num, tempMap.get(num) + 1);
            } else {
                tempMap.put(num, 1);
            }
        }
        // Note til mig selv - Iterator: https://en.wikipedia.org/wiki/Iterator#Java
        Set<Integer> tempSet = tempMap.keySet();
        Iterator<Integer> itr = tempSet.iterator();
        Integer min = itr.next();

        while(itr.hasNext()) {
            Integer current = itr.next();
            if (tempMap.get(current) < tempMap.get(min)) {
                min = current;
            }
        }
        return min;
    }
}
