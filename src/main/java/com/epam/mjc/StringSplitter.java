package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        StringBuilder delim = new StringBuilder();
        for (String str : delimiters) {
            delim.append(str);
        }

        StringTokenizer stringTokenizer = new StringTokenizer(source, delim.toString());
        List<String> list = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            list.add(stringTokenizer.nextToken());
        }

        return list;
//        throw new UnsupportedOperationException("You should implement this method.");
    }
}
