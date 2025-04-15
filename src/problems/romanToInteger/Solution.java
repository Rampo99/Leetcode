package problems.romanToInteger;

import java.util.*;

public class Solution {

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
     */

    public static void main(String[] args){
        romanToInt("MCMXCIV");
    }

    public static int romanToInt(String s) {

        Map<Character,Integer> romanToValue = new HashMap<>(){{
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }};

        int total = 0;

        for(int i = 0; i < s.length()-1; i++){
            if(romanToValue.get(s.charAt(i)) < romanToValue.get(s.charAt (i+1))){
                total -= romanToValue.get(s.charAt(i));
            } else {
                total += romanToValue.get(s.charAt(i));
            }
        }

        return total + romanToValue.get(s.charAt(s.length() - 1));
    }

}
