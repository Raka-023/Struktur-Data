import java.util.Scanner;

public class InfixToPostfix {

 static class CharStack {

    private char[] data;
    private int top;

    CharStack(int size) {
        data = new char[size];
        top = -1;
    }

    void push(char c) {
        data[++top] = c;
    }

    char pop() {
        return data[top--];
    }

    char peek() {
        return data[top];
    }

    boolean isEmpty() {
        return top == -1;
    }
}

static class IntStack {

    private int[] data;
    private int top;

    IntStack(int size) {
        data = new int[size];
        top = -1;
    }

    void push(int x) {
        data[++top] = x;
    }

    int pop() {
        return data[top--];
    }

    boolean isEmpty() {
        return top == -1;
    }
}
    
    static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    static boolean isRightAssociative(char c) {
        return c == '^';
    }

    public static String infixToPostfix(String s) {
        CharStack st = new CharStack(s.length());
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {

            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                res.append(s.charAt(i));
                i++;
            }

                res.append(' ');
                i--;
            }

            else if (c == '(')
                st.push('(');

            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            }

            else {
                while (!st.isEmpty() && st.peek() != '(' &&
                       (prec(st.peek()) > prec(c) ||
                       (prec(st.peek()) == prec(c) && !isRightAssociative(c)))) {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.toString();
    }


    static int floorDiv(int a, int b) {
        if (a * b < 0 && a % b != 0)
            return (a / b) - 1;
        return a / b;
    }
    
    public static int evaluatePostfix(String postfix) {

    IntStack st = new IntStack(postfix.length());

    for (int i = 0; i < postfix.length(); i++) {

        char token = postfix.charAt(i);

        if (token == ' ')
            continue;

        if (Character.isDigit(token)) {

    int num = 0;

    while (i < postfix.length() && Character.isDigit(postfix.charAt(i))) {
        num = num * 10 + (postfix.charAt(i) - '0');
        i++;
    }

        st.push(num);
        i--;
    }
        else {
            int val1 = st.pop();
            int val2 = st.pop();

            int result = 0;

            if (token == '+') result = val2 + val1;
            else if (token == '-') result = val2 - val1;
            else if (token == '*') result = val2 * val1;
            else if (token == '/') result = val2 / val1;
            else if (token == '^')
                result = (int)Math.pow(val2, val1);

            System.out.println(
                val2 + " " + token + " " + val1 + " = " + result
            );

            st.push(result);
        }
    }

    return st.pop();
}



public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Masukkan ekspresi: ");
    String exp = sc.nextLine();
    exp = exp.replaceAll(" ", "");

    String postfix = infixToPostfix(exp);
    System.out.println();

    System.out.println("Postfix: " + postfix);
    System.out.println();

    int hasil = evaluatePostfix(postfix);
    System.out.println();

    System.out.println("Hasil akhir= " + hasil);

    sc.close();
}
}