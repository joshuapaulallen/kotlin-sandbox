package challenge.advent

import java.util.regex.Pattern

class ChallengeInputTools private constructor() {

    companion object {

        /**
         * Split a challenge input string with many lines into a list where each item is one line from the input.
         */
        fun parse(str: String): List<String> = str.split(Pattern.compile("\\s+"))

        /**
         * Split a challenge input file at the given resource path into lines of text.
         */
        fun parseResource(path: String): List<String> = parse(FileTools.readEntireFileFromResource(path))

        /**
         * Split a challenge input string with many lines, with one item per line and groups of items delimited by
         * more than one newline, into a list.
         */
        fun parseGroups(str: String): List<List<String>> = str.split(Pattern.compile("\\s{2,}")).map(this::parse)

        /**
         * Split a challenge input file at the given resource path into groups of input.
         */
        fun parseResourceIntoGroups(path: String) = parseGroups(FileTools.readEntireFileFromResource(path))
    }

}