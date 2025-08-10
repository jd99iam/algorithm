package bruteforce;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {

    public static List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    public static int k;
    public static int target = 11;

    /**
     * [4,9,7,5,1] 에서 k 개 합해서 target 이 되는 경우 다 구하기 (중복 X)
     *
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 1; i <= 3; i++) {
            k = i;
            List<List<Integer>> answer = new ArrayList<>();

            List<Integer> current = new ArrayList<>();

            backTracking(answer, current, 0);

            System.out.println(i + "개 수를 더해서" + target + " 이 되는 조합 수 : " + answer.size());

            for (List<Integer> combination : answer) {
                for (Integer num : combination) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }

    public static List<List<Integer>> backTracking(List<List<Integer>> answer, List<Integer> current, int start) {
        int sum = 0;
        for (Integer val : current) {
            sum += val;
        }

        // k 개 원소 합이 target의 되는지 확인
        if (current.size() == k && sum == target) {
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
