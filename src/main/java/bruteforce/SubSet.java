package bruteforce;

import java.util.ArrayList;
import java.util.List;

public class SubSet {

    public static List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4));
    public static int k;

    /**
     * [1,2,3,4] 의 모든 부분집합 구하기
     *
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 0; i <= nums.size(); i++) {
            k = i;
            List<List<Integer>> answer = new ArrayList<>();

            List<Integer> current = new ArrayList<>();

            backTracking(answer, current, 0);

            System.out.println("원소가 " + k + "개인 부분집합 개수 : " + answer.size());

            for (List<Integer> combination : answer) {
                for (Integer num : combination) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }

    public static List<List<Integer>> backTracking(List<List<Integer>> answer, List<Integer> current, int start) {
        if (current.size() == k) {
            answer.add(new ArrayList(current));
            return answer;
        }

        for (int i = start; i < nums.size(); i++) {
            current.add(nums.get(i));
            backTracking(answer, current, i + 1);
            current.remove(current.size() - 1);
        }

        return answer;
    }
}
