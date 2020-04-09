package com.Text.TextElements;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Word> sentence;
    private SentenceType sentenceType;


    public List<Word> getSentence() {
        return sentence;
    }

    public void setSentence(List<Word> sentence) {
        this.sentence = sentence;
    }

    public SentenceType getSentenceType() {
        return sentenceType;
    }

    public void setSentenceType(SentenceType sentenceType) {
        this.sentenceType = sentenceType;
    }

    public Sentence(List<Word> sentence){
        this.sentence = sentence;
    }

    public Sentence(){
        this.sentence = new ArrayList<Word>();
    }

    public void add(Word word){
        sentence.add(word);
    }

    public Word getLastWord(){
        Word w = new Word();
        for(Word word : sentence){
            w = word;
        }
        return w;
    }

    public int getLength(){
        return sentence.size();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Sentence){
            Sentence s = (Sentence)obj;
            return this.sentence.equals(s.sentence) && this.sentenceType.equals(s.sentenceType);
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("");
        for(Word w  : sentence){
            result.append(w + " ");
        }
        return result.toString();
    }

}
