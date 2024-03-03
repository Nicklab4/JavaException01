package s2_task08;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task08 {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("1.tzt"));
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

    }
}
