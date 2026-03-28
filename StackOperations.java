package project_files;
public class StackOperations {
    String stp = "25101";
    int top = -1;
    char[] st = new char[stp.length()];
    
    public void push(char ch) {
        st[++top] = ch;
    }
    
    public void pop() {
        top--;
    }
    
    public char peek() {
        return st[top];
    }
    
    public boolean HTcheck(long ht) {
        top = -1;
        for (int i = stp.length() - 1; i >= 0; i--) {
            push(stp.charAt(i));
        }
        String str = String.valueOf(ht);
        for (int i = 0; i < stp.length(); i++) {
            if (peek() == str.charAt(i)) {
                pop();
            } else {
                return false;
            }
        }
        return true;
    }
}