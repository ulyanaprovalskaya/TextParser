package com.text.textElements;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private static final Logger LOGGER = LogManager.getLogger(Text.class);

    private List<Paragraph> paragraphs;

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public Text(){
        this.paragraphs = new ArrayList<>();
    }

    public Text(String text){
        this.paragraphs = new ArrayList<>();

        text = text.trim();
        String[] paragraphs = text.split("\n");
        for(String paragraph : paragraphs){
            this.paragraphs.add(new Paragraph(paragraph));
        }

        LOGGER.info("Text was parsed");
    }

    public List<Sentence> getSentences(){
        List<Sentence> sentences = new ArrayList<>();

        for(Paragraph p : getParagraphs()){
            sentences.addAll(p.getSentences());
        }

        return sentences;
    }


    @Override
    public boolean equals(Object obj){
        if(obj instanceof Text){
            Text text = (Text)obj;
            if(text.getParagraphs().equals(text.getParagraphs())) return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("");
        for(Paragraph p : paragraphs){
            result.append(p);
        }
        return result.toString();
    }

}
