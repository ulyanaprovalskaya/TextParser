package com.text.textElements;

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
