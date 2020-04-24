package com.text.textElements;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Word> words;
    private SentenceType sentenceType;


    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public SentenceType getSentenceType() {
        return sentenceType;
    }

    public void setSentenceType(SentenceType sentenceType) {
        this.sentenceType = sentenceType;
    }

    public Sentence(List<Word> words){
        this.words = words;
    }

    public Sentence(){
        this.words = new ArrayList<>();
    }

    public Sentence(String sentence){
        this.words = new ArrayList<>();

        String words[] = sentence.split(" ");
        for(String word : words){
            if(!word.equals("")) this.words.add(new Word(word));
        }

        this.sentenceType = determineSentenceType(this);
    }

    public void add(Word word){
        words.add(word);
    }

    public Word getLastWord(){
        return  words.get(words.size() - 1);
    }

    public int getLength(){
        return words.size();
    }

    public static SentenceType determineSentenceType(Sentence sentence){
        Punctuation lastWordPunctuation = sentence.getLastWord().getPunctuation();
        if(lastWordPunctuation.toString().equals("?")) return SentenceType.INTERROGATIVE;
        if(lastWordPunctuation.toString().equals("!")) return SentenceType.IMPERATIVE;
        return SentenceType.DECLARATIVE;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Sentence){
            Sentence s = (Sentence)obj;
            return this.words.equals(s.words) && this.sentenceType.equals(s.sentenceType);
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("");
        for(Word w  : words){
            result.append(" " + w);
        }
        return result.toString();
    }

}
