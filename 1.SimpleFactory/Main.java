import java.util.*;
class Main {
    static int n = 100000 + 10;
    static int[] e = new int[n];
    static int[] ne = new int[n];
    static int[] be = new int[n];
    static int idx = 2;
    static int head = 0;

    static int tail = 1;

    public static void main(String[] args) {
        be[0] = -1;
        ne[0] = 1;
        be[1] = 0;
        ne[1] = -1;
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        System.out.println(M);
        String tt = sc.nextLine();
        System.out.println(tt);
        System.out.println(M);
        for (int i = 0; i < M; i++) {
            String str = sc.nextLine();
            System.out.println(str);
            String[] strArr = str.split(" ");
            if (strArr[0].equals("L")) {
                int x = Integer.parseInt(strArr[1]);
                e[idx] = x;
                int headNext = ne[head];
                ne[head] = idx;
                be[idx] = head;

                be[headNext] = idx;
                ne[idx] = headNext;
                idx++;

            } else if (strArr[0].equals("R")) {
                int x = Integer.parseInt(strArr[1]);
                e[idx] = x;
                int tailBefore = be[tail];
                ne[tailBefore] = idx;
                be[idx] = tailBefore;

                ne[idx] = tail;
                be[tail] = idx;
                idx++;

            } else if (strArr[0].equals("D")) {
                int k = Integer.parseInt(strArr[1]);
                int index = k + 1;
                int front = be[index];
                int behind = ne[index];
                ne[front] = behind;
                be[behind] = front;
            } else if (strArr[0].equals("IL")) {
                int x = Integer.parseInt(strArr[1]);
                int k = Integer.parseInt(strArr[2]);
                int index = k + 1;
                int front = be[index];
                e[idx] = x;
                ne[front] = idx;
                be[index] = idx;

                ne[idx] = front;
                be[idx] = index;
                idx++;
            } else if (strArr[0].equals("IR")) {
                int x = Integer.parseInt(strArr[1]);
                int k = Integer.parseInt(strArr[2]);
                int index = k + 1;
                int behind = ne[index];
                e[idx] = x;
                ne[index] = idx;
                be[behind] = idx;

                ne[idx] = behind;
                be[idx] = index;
                idx++;

            }
        }
        int index = ne[head];
        while (index != tail) {
            System.out.print(e[index] + " ");
            index = ne[index];
        }
    }

}