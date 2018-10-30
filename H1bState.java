import java.io.*;
import java.util.*;
import java.util.stream.*;

public class H1bState
{
public static void main(String[] args) throws Exception
  {
   
   
    FileReader fr = new FileReader("C:\\Users/Shreya Chigullapalli/Desktop/java files/insight/input.csv");
    BufferedReader br= new BufferedReader(fr);
    File f = new File("C:\\Users/Shreya Chigullapalli/Desktop/java files/insight/input.csv");
    Scanner sc = new Scanner(f);
     
 HashMap<String, Integer> map = new HashMap<String, Integer>();

   String line=null;
while((line=br.readLine())!=null)
{
String tmp[] = line.split(";");
String state= tmp[50];

String status= tmp[2];

if(status.equals("CERTIFIED"))
{
if(map.containsKey(state))
{
int count = map.get(state)+1;
map.put(state, count);
}
else
{
map.put(state,1);
}
}
}
List<Map.Entry<String, Integer>> list1 = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>(){
public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
return o2.getValue().compareTo(o1.getValue());
}
});


PrintStream out = new PrintStream(new FileOutputStream("top_states.txt"));
String key;
Integer value;
float percent=0.0f;
int sum=0;

for(int q:map.values())
{
sum=sum+q;
}

for(Map.Entry<String, Integer> item : list1)
{

key= item.getKey();
value = item.getValue();
out.println(key+" ; "+value+" ; "+((value*100.0f)/sum)+"%");
}



    
}
}