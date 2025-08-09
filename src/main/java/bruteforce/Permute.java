package bruteforce;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    static List<Integer> nums = new ArrayList<>(List.of(1,2,3,4));

    /**
     * [1,2,3,4] 로 만들 수 있는 모든 순열 구하기 
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backTracking(current, answer);


        System.out.println("순열 개수  : "+answer.size());

        for (List<Integer> permute : answer){
            for (Integer num : permute){
                System.out.print(num+" "); 
            }
            System.out.println();
        }

    }
    public static List<List<Integer>> backTracking(List<Integer> current,  List<List<Integer>> answer){
        if (nums.size()==current.size()){
            answer.add(new ArrayList<>(current));
            return answer;
        }

        for (Integer num : nums){
            if (!current.contains(num)){
                current.add(num);
                backTracking(current, answer);
                current.remove(current.size()-1);
            }
        }
        return answer;
    }
}
