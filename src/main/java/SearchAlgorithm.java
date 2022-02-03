package src.main.java;

public class SearchAlgorithm {

    private int[] d;

    public int[] getD() {
        return d;
    }

    public SearchAlgorithm(String input) {
        OffsetTable(input);
    }

    private void OffsetTable(String input){
        int[] d = new int[input.length()];
        int len = input.length();
        int index = 1;
        for(int i = len - 2; i >= 0; i--){
            d[i] = index;
            for(int j = i + 1; j < len; j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    if(j == len - 1){
                        d[j] = d[i];
                    }
                    else{
                        d[i] = d[j];
                    }
                }
            }
            index += 1;
        }
        if(d[len - 1] == 0){
            d[len - 1] = len;
        }
        this.d = d;
    }

    public boolean CheckFirstEntry(String input, String text){
        int len = input.length();
        int lastI = len - 1;
        if(input.length() > text.length()){
            return false;
        }
        for(int i = lastI; i < text.length();) {
            for (int j = len - 1; j >= 0; j--) {
                if (text.charAt(i) != input.charAt(j)) {
                    int index = input.indexOf(text.charAt(i));
                    if(index == -1){
                        lastI += len;
                    }
                    else{
                        lastI += d[index];
                    }
                    i = lastI;
                    break;
                }
                i -= 1;
                if(j == 0){
                    return true;
                }
            }
        }
        return false;
    }

}
