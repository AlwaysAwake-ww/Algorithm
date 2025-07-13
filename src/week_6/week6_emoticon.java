package week_6;


// 이모티콘 할인 행사
// https://school.programmers.co.kr/learn/courses/30/lessons/150368?language=java

public class week6_emoticon {


    private int plus = 0;
    private int buy = 0;

    public int[] solution(int[][] users, int[] emoticons) {

        int[] arr = new int[emoticons.length];
        recursive(arr, 0, users, emoticons);

        return new int[]{plus, buy};
    }


    public void recursive(int[] arr, int startIdx, int[][] users, int[] emoticons){

        if(startIdx == arr.length){

            calc(arr, users, emoticons);
            return;
        }

        for(int i=10; i<=40; i+=10){

            arr[startIdx] = i;
            recursive(arr, startIdx+1 ,users, emoticons);

        }

    }

    private void calc(int[] arr, int[][] users, int[] emoticons){

        int cnt = 0;
        int buySum = 0;

        for(int i=0; i<users.length; i++){

            int userPer = users[i][0];
            int userLimit = users[i][1];

            int sum = 0;

            for(int j=0; j<arr.length; j++){

                if(arr[j] >= userPer){

                    //sum += emoticons[j] * (100 - arr[j]) / 100;
                    sum += (int) Math.floor(emoticons[j] * (1 - arr[j] / 100.0)); // 실수 연산 후 버림
                }
            }

            if(sum >= userLimit){

                // 유저 구매 상한보다 높으면 이모티콘 플러스 가입
                cnt++;
            } else{

                // 낮으면 그냥 구매
                buySum+=sum;
            }


        }

        if(cnt > plus){
            plus = cnt;
            buy = buySum;
        }

        if(cnt == plus){

            if(buy < buySum){
                buy = buySum;
            }
        }
    }



}
