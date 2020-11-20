package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public ArrayList<TagGroup> findTags(String url) throws IOException {
        ArrayList<String> tags = new ArrayList<>();
        ArrayList<TagGroup> tagGroups = new ArrayList<>();

        Document doc = Jsoup.connect(url).get();
        Pattern p = Pattern.compile("<([^\\s>/]+)");
        Matcher m = p.matcher(doc.toString());

        while(m.find()) {
            tags.add(m.group(1));
        }

        boolean tagAlreadyInGroup = false;
        tagGroups.add(new TagGroup(tags.get(0), 1));
        for(int i = 1; i < tags.size(); i++) {
            tagAlreadyInGroup = false;
            for(int j = 0; j < tagGroups.size(); j++) {
                if(tags.get(i).equals(tagGroups.get(j).getName())) {
                    tagAlreadyInGroup = true;
                    tagGroups.get(j).setCount(tagGroups.get(j).getCount() + 1);
                    break;
                }
            }
            if(!tagAlreadyInGroup) {
                tagGroups.add(new TagGroup(tags.get(i), 1));
            }
        }

        return tagGroups;
    }
}
