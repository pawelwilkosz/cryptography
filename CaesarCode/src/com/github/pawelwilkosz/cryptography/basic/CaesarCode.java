package com.github.pawelwilkosz.cryptography.basic;

public class CaesarCode {
    private final int OFFSET = 3;
    private final int ALPHABET_LENGTH = 26;
    private final char FIRST_LETTER_LOWERCASE = 'a';
    private final char FIRST_LETTER_UPPERCASE = 'A';

    private int calculatePositionInAlphabet(char c){
        return (Character.isLowerCase(c))? c - FIRST_LETTER_LOWERCASE
                : c - FIRST_LETTER_UPPERCASE;
    }

    private char getNextCharacter(char c, int next){
        return (Character.isLowerCase(c))? (char)(FIRST_LETTER_LOWERCASE + next)
                : (char)(FIRST_LETTER_UPPERCASE + next);
    }

    public String decode(String textToDecode){
        StringBuilder sb = new StringBuilder();
        int positionInAlphabet = 0;

        for(char c : textToDecode.toCharArray()){
            if(!Character.isLetter(c))
                throw new IllegalArgumentException("String contains numeric character which is forbidden");

            positionInAlphabet = calculatePositionInAlphabet(c);
            int nextPosition = (positionInAlphabet + OFFSET) % ALPHABET_LENGTH;
            char decodedCharacter = getNextCharacter(c, nextPosition);

            sb.append(decodedCharacter);
        }

        return sb.toString();
    }

    public String encode(String textToEncode){
        StringBuilder sb = new StringBuilder();
        int positionInAlphabet = 0;

        for(char c : textToEncode.toCharArray()){
            if(!Character.isLetter(c))
                throw new IllegalArgumentException("String contains numeric character which is forbidden");

            positionInAlphabet = calculatePositionInAlphabet(c);
            int previousPosition = (positionInAlphabet - OFFSET) % ALPHABET_LENGTH;
            char encodedCharacter = getNextCharacter(c, previousPosition);

            sb.append(encodedCharacter);
        }

        return sb.toString();
    }
}
