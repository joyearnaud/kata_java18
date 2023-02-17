package com.kata.codewars.whoLikesIt;

public class WhoLikesIt {
    public static final String NO_ONE = "no one likes this";
    public static final String LIKES = "likes this";
    public static final String LIKE = "like this";
    public static final String AND = "and";
    public static final String OTHERS = "others";
    public static final String COMA = ",";

    public static String whoLikesIt(String... names) {
        //-inf to 0 persons
        if (names.length <= 0) {
            return NO_ONE;
        }

        //1 to 3 persons
        if(names.length == 1)
            return names[0] + LIKES;
        if(names.length == 2)
            return names[0] + AND + names[1] + LIKE;
        if(names.length == 3)
            return names[0] + COMA + names[1] + AND + names[2] + LIKE;

        //4 to +inf persons
        return names[0] + COMA + names[1] + AND + (names.length - 2) + OTHERS + LIKE;
    }

    public static String whoLikesIt2(String... names) {
        final String NO_ONE = "no one";
        final String LIKES = "likes this";
        final String LIKE = "like this";
        final String OTHERS = "others";
        final String AND = "and";

        String t0 = NO_ONE + " " + LIKES;
        String t1 = "%s " + LIKES;
        String t2 = "%s " + AND + " %s " + LIKE;
        String t3 = "%s, %s " + AND + " %s " + LIKE;
        String t4 = "%s, %s " + AND + " %d " + OTHERS + " " + LIKE;

        switch (names.length) {
            case 0 -> { return t0; }
            case 1 -> { return String.format(t1, names); }
            case 2 -> { return String.format(t2, names); }
            case 3 -> { return String.format(t3, names); }
            default -> { return String.format(t4, names[0], names[1], names.length - 2); }
        }
    }
}
