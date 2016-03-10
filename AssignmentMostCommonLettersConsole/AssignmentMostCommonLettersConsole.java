import java.util.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;


public class AssignmentMostCommonLettersConsole{
    
    public static int MAX_ENTRIES = 19;
    
    public static void main(String[] args) {
        
        Scanner inputReader = new Scanner(System.in);
        String inputText = inputReader.nextLine().toLowerCase();
        List<Character> charList = new ArrayList<>();
            for(char addChar : inputText.toCharArray()){
                if (addChar != ' ' && Character.isLetter(addChar)) {
                  charList.add(addChar);  
                }
            }

            Map<Character, Integer> ch = new HashMap<>();
            for(char a : charList){
                Integer chLetter = ch.get(a);
                ch.put(a, (chLetter == null ) ? 1 : chLetter+1);
            }
            
            Set<Entry<Character, Integer>> set = ch.entrySet();
            List<Entry<Character, Integer>> list = new ArrayList<>(set);
            Collections.sort( list, new Comparator<Map.Entry<Character, Integer>>()
            {
                public int compare( Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2 )
                {
                    return (o2.getValue()).compareTo( o1.getValue() );
                }
            });
            
            int counter = 0;
            for(Map.Entry<Character, Integer> entry:list){
                if (counter<=MAX_ENTRIES) {
                    System.out.print(entry.getKey() + " : "+entry.getValue()+" ");
                    System.out.println(repeatString("#", entry.getValue()*5));
                }
                   counter++;
            }
    }
    
    public static String repeatString(String str, int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}

