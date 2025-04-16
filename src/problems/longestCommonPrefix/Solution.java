package problems.longestCommonPrefix;

public class Solution {

    public static void main(String[] args){
        String[] s = new String[]{"flower","flow","flight"};
        longestCommonPrefix(s);
    }

    public static String longestCommonPrefix(String[] args) {
        if(args.length == 0) return "";
        if(args[0].isEmpty()) return "";
        String prefix = String.valueOf(args[0].charAt(0));
        int index = 0;
        for(int count = 0; count < args.length; count++){
            String s = args[count];
            if(s.length() <= index) {
                prefix = prefix.substring(0,prefix.length()-1);
                break;
            }
            String sPrefix = s.substring(0,index+1);
            if(!prefix.equals(sPrefix)) {
                prefix = prefix.substring(0,prefix.length()-1);
                break;
            }
            if(count == args.length-1){
                count = 0;
                index++;
                if(args[0].length() == index){
                    break;
                }
                prefix = prefix.concat(String.valueOf(args[0].charAt(index)));
            }
        }
        return prefix;
    }
}
