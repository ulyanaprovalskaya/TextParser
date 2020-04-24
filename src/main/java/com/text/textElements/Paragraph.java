package com.text.textElements;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {

    private List<Sentence> sentences;

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Paragraph(){
        sentences = new ArrayList<>();
    }

    public Paragraph(String paragraph){
        this.sentences = new ArrayList<>();

        String[] sentences = paragraph.split("\\.|!|\\?");
        for(String sentence : sentences){
            int i = paragraph.indexOf(sentence) + sentence.length();
            this.sentences.add(new Sentence(sentence + paragraph.charAt(i)));
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("");
        for(Sentence s : sentences){
            result.append(s);
        }
        return result.toString() + "\n";
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Paragraph){
            Paragraph paragraph = (Paragraph)obj;
            if(paragraph.getSentences().equals(paragraph.getSentences())) return true;
        }
        return false;
    }
}
