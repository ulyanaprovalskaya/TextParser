package com.text.textElements;

public class Punctuation {
    public static String punctuation = ".,:;!?–";
    public static String endPunctuationSign = ".?!";

    private char sign;

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public Punctuation(char sign){
        this.sign = sign;
    }

    @Override
    public String toString(){
        return Character.toString(sign);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof  Punctuation){
            Punctuation p = (Punctuation)obj;
            return this.sign == p.sign;
        }
        return false;
    }
}
