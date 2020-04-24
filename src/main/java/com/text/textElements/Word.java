package com.text.textElements;

import org.apache.commons.lang3.StringUtils;

public class Word {
    private String word;
    private Punctuation punctuation;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Punctuation getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(Punctuation punctuation) {
        this.punctuation = punctuation;
    }

    public Word(){}

    public Word(String word){
        if(StringUtils.indexOfAny(word, Punctuation.punctuation) != -1){
            this.word = word.substring(0, word.length() - 1);
            this.punctuation = new Punctuation(word.charAt(word.length() - 1));
        }
        else this.word = word;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof  Word){
            Word w = (Word)obj;
            return this.word.equals(w.word) && this.punctuation.equals(w.punctuation);
        }
        return false;
    }

    @Override
    public String toString(){
        if(punctuation == null) return word;
        return word + punctuation;
    }
}
