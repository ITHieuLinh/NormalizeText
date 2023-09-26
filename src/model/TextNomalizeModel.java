package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextNomalizeModel {

    public String normalizeText(String input) {
        String[] sentences = input.split("(?<=[.!?])\\s+");

        StringBuilder normalizedText = new StringBuilder();

        for (String sentence : sentences) {
            sentence = sentence.trim();
            if (!sentence.isEmpty()) {
                sentence = normalizeLine(sentence);
                normalizedText.append(sentence).append(" ");
            }
        }

        return normalizedText.toString().trim() + ".";
    }

    private String normalizeLine(String line) {
        line = line.replaceAll("\\s+", " ");
        
        line = line.replaceAll("\\s*,\\s*", ", ");
        line = line.replaceAll("\\s*\\.\\s*", ".");  
        line = line.replaceAll("\\s*:\\s*", ": ");
        
        line = capitalizeFirstCharacter(line);
        
        line = line.replaceAll("\\s*\"\\s*", "\"");

        return line;
    }

    private String capitalizeFirstCharacter(String line) {
        Pattern pattern = Pattern.compile("(^|[.!?]\\s+|\"\\s+)([a-z])");
        Matcher matcher = pattern.matcher(line);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group(1) + matcher.group(2).toUpperCase());
        }

        matcher.appendTail(result);

        return result.toString();
    }
}
