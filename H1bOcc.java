import java.io.*;
import java.util.*;
import java.util.stream.*;

public class H1bOcc
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
String job= tmp[24];

//System.out.println(state);
//System.out.println(job);
String status= tmp[2];

if(status.equals("CERTIFIED"))
{
if(map.containsKey(job))
{
int count = map.get(job)+1;
map.put(job, count);
}
else
{
map.put(job,1);
}
}
}
List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
return o2.getValue().compareTo(o1.getValue());
}
});


PrintStream out = new PrintStream(new FileOutputStream("top_occupations.txt"));


String key;
Integer value;
float percent=0.0f;
int sum=0;
for(int q:map.values())
{
sum=sum+q;
}

for(Map.Entry<String, Integer> item : list)
{

key= item.getKey();
value = item.getValue();
out.println(key+" ; "+value+" ; "+((value*100.0f)/sum)+"%");
}





    
}
}