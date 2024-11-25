package com.gaurav.dsakotlinlib.string

fun main() {

    val str = "Hello"
    val str2 = "A man, a plan, a canal: Panama"
//    println("Reversed String: ${reverseString(str)}")
//    println("Is Pallindrome: ${isPallendromeWithoutBuiltIn(str2)}")
    val anaStr1 = "Listen"
    val anaSt2 = "Silent"
//    println("Are Anagrams: ${areAnagrams(anaStr1,anaSt2)}")

    val str3 = "swiss"
//    println("First Non-Repeating Char: ${firstNonRepeatingChar(str3)}")
    val str4 = "hello world"
    val target = 'l'
//    println("Character Count: ${countCharOccurrences2(str4, target)}")
    val str5 = "1234"
//    println("Contains Only Digits: ${containsOnlyDigits(str5)}")

    val str6 = "ABCD"
//    println("All possible permutations:")
//    permute(str6, 0, str6.length - 1)
    val str7 = "ABCD"
    val str8 = "DABC"
//    println("Is Rotation: ${isRotation(str7, str8)}")
//    println("Character Frequency: ${countCharacterFrequency(str4)}")
    val str9 = "Hello World from kotlin"
//    println("Title Case: ${toTitleCase(str9)}")
    val str10="programming"
//    println("Remove Duplicates: ${removeDuplicates(str10)}")
    val str11="abcabcbb"
    println("Length of Longest Substring: ${lengthOfLongestSubstring(str11)}")
}

//Problem: Given a string, reverse the string without using built-in reverse functions.
fun reverseString(str: String): String {
    val charArray = str.toCharArray()
    var start = 0
    var end = charArray.size - 1
    while (start < end) {
        var temp = charArray[start]
        charArray[start] = charArray[end]
        charArray[end] = temp
        start++
        end--
    }
    return String(charArray)
}

//Problem: Check if a given string is a palindrome (reads the same forward and backward).
fun isPallindrome(str: String): Boolean {
    val normalizedStr = str.filter { it.isLetterOrDigit() }.lowercase()
    return normalizedStr == normalizedStr.reversed()
}

//Approach 2 : without using built-in reverse functions

fun isPallendromeWithoutBuiltIn(str: String): Boolean {
    var start = 0
    var end = str.length - 1
    while (start < end) {
        if (!str[start].isLetterOrDigit()) {
            start++
            continue
        }
        if (!str[end].isLetterOrDigit()) {
            end--
            continue
        }
        if (str[start].lowercase() != str[end].lowercase()) {
            return false
        }
        start++
        end--
    }
    return true
}

//Problem: Given two strings, check if they are anagrams of each other (i.e., they contain the same characters in any order).

fun areAnagrams(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) {
        return false
    }
    val sortedStr1 = str1.replace("\\s", "").lowercase().toCharArray().sorted()
    val sortedStr2 = str2.replace("\\s", "").lowercase().toCharArray().sorted()
    return sortedStr1 == sortedStr2
}

//Problem: Find the first character in a string that does not repeat.
fun firstNonRepeatingChar(str: String): Char? {
    val charCount = mutableMapOf<Char, Int>()
    for (char in str) {
        charCount[char] = charCount.getOrDefault(char, 0) + 1
    }
    for (char in str) {
        if (charCount[char] == 1)
            return char
    }

    return null;
}

//Problem: Count how many times a specific character appears in a given string.
// Approach 1
fun countCharOccurrences(str: String, target: Char): Int {
    var count = 0
    for (char in str) {
        if (char == target) {
            count++
        }
    }
    return count
}

//Approach 2
fun countCharOccurrences2(str: String, target: Char): Int {
    return str.count { it == target }
}

//Problem: Given a string, check if it contains only numeric characters.
fun containsOnlyDigits(str: String): Boolean {
    return str.all { it.isDigit() }
}

//Problem: Given a string, find all possible permutations of the string.
fun permute(str: String, left: Int, right: Int) {
    if (left == right)
        println(str)
    else {
        for (i in left..right) {
            val swapped = swap(str, left, i)
            permute(swapped, left + 1, right)
        }
    }
}

fun swap(str: String, left: Int, right: Int): String {
    val charArray = str.toCharArray()
    val temp = charArray[left]
    charArray[left] = charArray[right]
    charArray[right] = temp
    return String(charArray)
}

// Problem: Check if one string is a rotation of another string.
fun isRotation(str1: String, str2: String): Boolean {
    if (str1.length != str2.length)
        return false
    val concat= str1+str1

    return concat.contains(str2)
}

//Problem: Count the frequency of each character in a string.
fun countCharacterFrequency(str: String): Map<Char, Int> {
    val frequencyMap= mutableMapOf<Char,Int>()

    for (char in str){
        frequencyMap[char]=frequencyMap.getOrDefault(char,0)+1
    }
    return frequencyMap
}

//Problem: Convert a given string to title case where the first letter of each word is capitalized.
fun toTitleCase(str: String): String{
    val words=str.split(" ")
    val titleCaseWords=words.joinToString(" ") { it.replaceFirstChar { it.uppercase() } }
    return titleCaseWords
}

//Problem: Remove duplicate characters from a string, keeping only the first occurrence of each character.
fun removeDuplicates(str: String): String{
    val uniqueChars= mutableSetOf<Char>()
    val result=StringBuilder()
    for(char in str){
        if(uniqueChars.add(char)){
            result.append(char)
        }
    }
    return result.toString()
}

//Problem: Find the length of the longest substring without repeating characters. // Sliding window problem
fun lengthOfLongestSubstring(s: String): Int {
    var windowStart = 0
    var windowEnd = 0
    var maxLength = 0
    val charSet = HashSet<Char>()

    while (windowEnd < s.length) {
        if (!charSet.contains(s[windowEnd])) {
            charSet.add(s[windowEnd++])
            maxLength = maxOf(maxLength, charSet.size)
        } else {
            charSet.remove(s[windowStart++])
        }
    }

    return maxLength
}