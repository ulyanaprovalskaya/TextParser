package com.text.textParser;


import com.text.textElements.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextParser {
    private static final Logger LOGGER = LogManager.getLogger(TextParser.class);

    private static String punctuation = ".,:;!?–";
    private static String endPunctuationSign = ".?!";

    public static Text parse(String text){
        LOGGER.info("Text was parsed");
        List<Word> words = parseIntoWords(text);
        List<Sentence> sentences = parseIntoSentences(words);
        return new Text(sentences);
    }

    public static List<Word> parseIntoWords(String text){
        String words[] = text.split(" ");
        List<Word> wordsList = new ArrayList<>();
        for(String word : words){
            Word w = new Word();

            if(StringUtils.indexOfAny(word, punctuation) != -1){
                w.setWord(word.substring(0, word.length() - 1));
                w.setPunctuation(new Punctuation(word.charAt(word.length() - 1)));
            }
            else w.setWord(word);

            wordsList.add(w);
        }
        return wordsList;
    }

    public static List<Sentence> parseIntoSentences(List<Word> words){
        List<Sentence> sentences = new ArrayList<>();
        Sentence sentence = new Sentence();
        for(Word word : words){
            //String p = word.getPunctuation().toString();
            if(word.getPunctuation() != null && endPunctuationSign.contains(word.getPunctuation().toString())){
                sentence.add(word);
                sentence.setSentenceType(getSentenceType(sentence));
                sentences.add(sentence);
                sentence = new Sentence();
            }
            else sentence.add(word);
        }
        return sentences;
    }

    public static SentenceType getSentenceType(Sentence sentence){
        Punctuation lastWordPunctuation = sentence.getLastWord().getPunctuation();
        if(lastWordPunctuation.toString().equals("?")) return SentenceType.INTERROGATIVE;
        if(lastWordPunctuation.toString().equals("!")) return SentenceType.IMPERATIVE;
        return SentenceType.DECLARATIVE;
    }
}
