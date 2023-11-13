import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> mp = new HashMap<>();
        for (List<String> it : access_times) {
            int time = Integer.parseInt(it.get(1));
            mp.computeIfAbsent(it.get(0), k -> new ArrayList<>()).add(time);
        }
        for (List<Integer> times : mp.values()) {
            times.sort(null);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : mp.entrySet()) {
            List<Integer> times = entry.getValue();
            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) < 100) {
                    ans.add(entry.getKey());
                    break;
                }
            }
        }
        return ans;
    }
}


