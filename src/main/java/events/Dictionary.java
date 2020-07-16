package events;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    private String language;
    private HashMap <String, String[]> content;

    public Dictionary(String language) {
        this.language = language;
        this.content = new HashMap<>();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ArrayList<String> getContent() {
        ArrayList<String> contentList = new ArrayList<>();
        System.out.printf("%20s | %20s | %30s \n", "German", "Swedish", "Sample Sentence");
        System.out.println("---------------------------------------------------------------------------------------------");
        for(String item : this.content.keySet()){
           String newItem = String.format("%25s | %25s | %50s \n", item, this.content.get(item)[0], this.content.get(item)[1]);
            contentList.add(newItem);
        }
        return contentList;
    }
    public HashMap<String, String[]> getContentDict(){
        return content;
    }

    public void setContent(String key, String[] value) {
        this.content.put(key, value);
    }

    public String translateWord(String key){


       String[] values =  this.content.get(key);

        return String.format("%s \n------------------ \n Meaning: %s \n Sample Sentence: %s ", values[0], key, values[1]);

    }
}
