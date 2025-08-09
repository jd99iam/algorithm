package bruteforce;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4));
    public static int k = 2;

    /**
     * 1,2,3,4 에서 combination 으로 2 개 뽑는 모든 경우
     *
     * @param args
     */
    public static void main(String[] args) {

        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        backTracking(answer, current, 0);

        System.out.println("조합 개수  : "+answer.size());

        for (List<Integer> combination : answer){
            for (Integer num : combination){
                System.out.print(num+" "); 
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> backTracking(List<List<Integer>> answer, List<Integer> current, int start) {
        if (current.size() == k) {
            answer.add(new ArrayList(current));
            return answer;
        }

        for (int i = start; i < nums.size(); i++) {
            current.add(nums.get(i));
            backTracking(answer, current, i+1);
            current.remove(current.size()-1); 
        }

        return answer;
    }
}
