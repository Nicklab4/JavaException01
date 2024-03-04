package s2_task08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task08 {
    public static void main(String[] args) throws IOException {
        List<String> ls = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("1.txt"));
            String content = br.readLine();
            while (content != null){
                ls.add(content);
                content = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String i : ls  ){
            String[] parts = i.split("=");
            if (parts.length != 2)
                throw new IllegalArgumentException("Неверное количество аргументов");
            map.put(parts[0], parts[0].length());
        }

        StringBuilder sBuilder = new StringBuilder();
        for (String name : map.keySet()){
            sBuilder.append(name).append("=").append(map.get(name)).append("\n");
        }

        FileWriter fw = new FileWriter("1.txt");
        fw.write(String.valueOf(sBuilder));
        fw.flush();
        fw.close();

    }
}
