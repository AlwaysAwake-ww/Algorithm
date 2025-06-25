package week_1;

// 타겟 넘버
// https://school.programmers.co.kr/learn/courses/30/lessons/43165

public class week1_targetNumber {

    public int dfs(int[] numbers, int target, int index, int result){
        int size = numbers.length;
        if(index == size){
            return result == target ? 1 : 0;
        }
        return dfs(numbers, target, index+1, result+numbers[index]) + dfs(numbers, target, index+1, result-numbers[index]);
    }

    public int solution(int[] numbers, int target){
        int answer = dfs(numbers, target, 0,0);
        return answer;
    }
}
