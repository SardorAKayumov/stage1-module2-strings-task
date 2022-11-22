package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String accessModifier = null;
        String returnType;
        String methodName;
        List<MethodSignature.Argument> argumentsList = new ArrayList<>();

        List<String> list = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(signatureString, " (,)");
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }

        int index = 0;

        if(Objects.equals(list.get(index), "public") || Objects.equals(list.get(index), "private") || Objects.equals(list.get(index), "protected")) {
            accessModifier = list.get(index);
            index++;
        }

        returnType = list.get(index);
        index++;
        methodName = list.get(index);
        index++;

        for (int i  = index; i < list.size(); i += 2) {
            String argumentType = list.get(i);
            String argumentName = list.get(i+1);
            argumentsList.add(new MethodSignature.Argument(argumentType, argumentName));
        }

        MethodSignature methodSignature = new MethodSignature(methodName, argumentsList);
        methodSignature.setAccessModifier(accessModifier);
        methodSignature.setReturnType(returnType);

        return methodSignature;
//        throw new UnsupportedOperationException("You should implement this method.");
    }
}
