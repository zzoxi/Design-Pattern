package code;

import java.util.ArrayList;

public class LessN {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int n = 1230;

    }
    private int compute(int[] arr, int n) {
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            int find = bSearch(arr, num);
            if(find != -1) {
//                sb.append(String.valueOf(find));
                arrayList.add(find);
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    char c = sb.charAt(j);
                    int res = findLess(arr, c- '0');
                    if(res == -1) {
                        arrayList.remove(j);
                    }
                    else {
                        arrayList.set(j, res);
                        break;
                    }
                }
            }
        }
        return n;
    }

    private int bSearch(int[] arr, int find) {
        int maxval = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == find) return arr[i];
            else if(arr[i] < find) {
                maxval = Math.max(maxval, arr[i]);
            }
        }
        return maxval;
    }
    private int findLess(int[] arr, int find) {
        int maxval = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < find) {
                maxval = Math.max(maxval, arr[i]);
            }
        }
        return maxval;
    }
}
