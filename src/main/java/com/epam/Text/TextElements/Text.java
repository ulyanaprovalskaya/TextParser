package com.epam.Text.TextElements;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> sentences;

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Text(List<Sentence> sentences){
        this.sentences = sentences;
    }

    public Text(){
        this.sentences = new ArrayList<Sentence>();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Text){
            Text text = (Text)obj;
            if(text.getSentences().equals(text.getSentences())) return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("");
        for(Sentence s : sentences){
            result.append(s);
        }
        return result.toString();
    }
}
