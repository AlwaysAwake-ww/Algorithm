package week_1;

import java.util.Arrays;
import java.util.LinkedList;


// 캐시
// https://school.programmers.co.kr/learn/courses/30/lessons/17680
public class week1_cache {


    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0)
            return (int)Arrays.stream(cities).count()*5;

        LinkedList<String> cache = new LinkedList<>();

        for(String s : cities){

            s = s.toLowerCase();

            if(cache.remove(s)){
                answer += 1;
            } else {
                answer += 5;
                if(cache.size() == cacheSize)
                    cache.removeLast();
            }
            cache.push(s);

        }
        return answer;
    }
}
