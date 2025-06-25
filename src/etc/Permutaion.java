package etc;

public class Permutaion {

    // 순열
    // 서로 다른 n개에서 r개를 뽑아 정렬
    // arr : 주어진 배열
    // depth :  r까지 몇번째 자리 순열 만들었는지
    // r : 배열의 길이 >> 종료 조건으로 사용
    public void permutation(int[] arr, int depth, int r){

        // depth 가 r일때 > r개 다 골랐을 경우
        if (depth == r) {
            printArray(arr, r);
            return;
        }

        // deepth 부터 arr 길이까지 순회
        for (int i = depth; i < arr.length; i++) {

            // 현재 위치(depth)에 어떤 수를 놓을 지 선택
            swap(arr, depth, i);

            // depth 증가시켜 백트래킹
            permutation(arr, depth + 1, r);

            // 재귀 끝난 후 원상복구
            swap(arr, depth, i);
        }
    }

    // 숫자 swap 함수
    private void swap(int arr[], int a, int b){

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


}
