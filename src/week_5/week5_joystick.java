package week_5;

public class week5_joystick {

    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public int solution(String name) {
        int answer = 0;

        int horizontal = horizontal(name);
        for(char c : name.toCharArray()){

            int vertical = vertical(c);

            System.out.println("A to "+c+": "+vertical);
            answer += vertical;
        }
        return answer+horizontal;
    }


    private int horizontal(String name){

        int[] arr = new int[name.length()];
        for(int i=0; i<name.length(); i ++){

            if(!String.valueOf(name.charAt(i)).equals("A")){
                arr[i] = 1;
            }
        }
        for(int i : arr)
            System.out.print(i+" ");
        System.out.println();

        int forward = getForwardDistance(arr);
        int backward = getBackwardDistance(arr);

        return Math.min(forward, backward);
    }

    private int getForwardDistance(int[] arr) {
        int lastIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1)
                lastIdx = i;

        }
        System.out.println("## 정방향: "+lastIdx);
        return lastIdx;
    }

    private int getBackwardDistance(int[] arr) {
        int len = arr.length;
        int lastIdx = 0;
        // 0번은 무조건 제외하므로 1부터 시작
        for (int i = 1; i < len; i++) {
            int idx = (0 - i + len) % len; // 역방향 이동
            if (arr[idx] == 1) {
                lastIdx = i;
            }
        }
        System.out.println("## 역방향: "+lastIdx);
        return lastIdx;
    }

    private int vertical(char c){

        // 여기에 위, 아래로 돌리는거 중 뭐가 더 빠른가 판단
        // 시작은 무조건 A
        int from = 0;
        int to = alphabet.indexOf(c);
        return Math.min(Math.abs(to - from), 26 - Math.abs(to - from));
    }
}
