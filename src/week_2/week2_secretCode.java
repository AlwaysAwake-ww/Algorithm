package week_2;

// 비밀코드
// https://school.programmers.co.kr/learn/courses/30/lessons/388352

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class week2_secretCode {

    public int solution(int n, int[][] q, int[] ans) {
        AtomicInteger answer = new AtomicInteger(0);

        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) arr[i] = i+1;

        combination(arr, 0, 0, 5, q, ans, answer);

        return answer.get();
    }

    public void combination(int[] arr, int depth, int start, int r, int[][] q, int[] ans, AtomicInteger answer){

        if (depth == r) {

            if(check(q, ans, arr))
                answer.incrementAndGet();
            return;
        }

        for (int i = start; i < arr.length; i++) {

            swap(arr, depth, i);
            combination(arr, depth + 1, i + 1, r, q, ans, answer);
            swap(arr, depth, i);

        }
    }

    private void swap(int[] arr, int a, int b){

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public boolean check(int[][] q, int[] ans, int[] result){

        int cnt = 0;
        for(int i = 0; i < q.length; i++){
            for(int j = 0; j < q[i].length; j++){
                if(contains(q[i], result[j])){
                    cnt++;
                }
            }
            if(cnt != ans[i])
                return false;
            cnt=0;
        }
        return true;
    }

    public boolean contains(int[] arr, int target) {
        return Arrays.stream(arr).anyMatch(x -> x == target);
    }

}
