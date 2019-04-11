import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


/*
 * 
 */
public class Solution {
	
	
    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {

    	// **** number of members ****
    	int n = topic.length;
    	
    	// **** number of topics ****
    	int s = topic[0].length();
    	
    	// **** [0]: maximum number of topics  [1]:  number of teams ****
    	int[] result = new int [2];
    	
    	// ???? ????
//    	System.out.println("n: " + n);
//    	System.out.println("s: " + s);
//    	for (String str : topic)
//    		System.out.println("str ==>" + str + "<==");
 	
    	// **** ****
    	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    	
    	// **** combinations of 2 of n ****
    	int maxTopics = 0;
    	for (int i = 0; i < n; i++) {
    		
    		for (int j = i + 1; j < n; j++) {
    			
    			// ???? ????
    			System.out.println("(" + (i  + 1) + "," + (j + 1) + ")");
    			
    			// **** convert strings to character arrays ****
    			char[] sca = topic[i].toCharArray();
    			char[] scb = topic[j].toCharArray();

    			// **** determine the max topics ****
    			int count = 0;
    			for (int k = 0; k < s; k++) {
    				
    				// ???? ????
    				System.out.println("sca: " + (int)sca[k] + " scb: " + (int)scb[k]);
    				System.out.println("sca | scb: " + (sca[k] | scb[k]));
    				
    				// **** 49 = '1' ****
    				if ((sca[k] | scb[k]) == 49)
    					count++;
    			}
    			
    			// ???? ????
    			System.out.println("count: " + count);
    			
    			// **** update the maximum number of topics (if needed) ****
    			if (count > maxTopics)
    				maxTopics = count;
    					
    			// **** add to hash map ****
    			if (hm.containsKey(count)) {
    				int value = hm.get(count);
    				value++;
    				hm.put(count, value);
    			} else {
    				hm.put(count, 1);
    			}
    		}
    		
    	}
    	 	
    	// ???? ????
    	System.out.println("hm: " + hm.toString());
    	
    	// **** ****
    	int maxVal = 0;
    	int maxKey = 0;
    	for (Entry<Integer, Integer> e: hm.entrySet()) {
    		int key = e.getKey();
    		int val = e.getValue();
    		
    		if (key > maxKey) {
    			maxVal = val;
    			maxKey = key;
    		}
    		
    	}
    	
    	// ???? ????
    	System.out.println("maxKey: " + maxKey);
    	System.out.println("maxVal: " + maxVal);
    		
    	// **** ****
    	result[0] = maxTopics;
    	result[1] = maxVal;

    	// **** ****
    	return result;
    }

    
    private static final Scanner scanner = new Scanner(System.in);

    
    // **** testing scaffolding ****
	public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        // **** ****
        int[] result = acmTeam(topic);

        // **** ****
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        // **** close buffered writer ****
        bufferedWriter.close();

        // **** close scanner ****
        scanner.close();
	}		

}
