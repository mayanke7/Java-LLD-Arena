
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Main {

    // 100000a
    public static void main(String args[]) {
        List<Long> list = new ArrayList<>();
        Map<Long, Integer> elementFreq = new HashMap<>();

        for (Long element : list) {
            if (elementFreq.containsKey(element)) {
                Integer prevFreq = elementFreq.get(element);
                elementFreq.put(element, prevFreq + 1);
            } else {
                elementFreq.put(element, 1);
            }
        }

        list= new ArrayList<>();
        for(Long e: elementFreq.keySet()){
            list.add(e);
        }
    }

    

}

/// rea

