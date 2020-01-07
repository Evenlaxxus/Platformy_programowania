import functools
import re
from collections import Counter


def increment(tab):
    gen_exp = (x + 1 for x in tab)
    for x in gen_exp:
        print(x)


def iloczyn(ciag_liczb):
    return functools.reduce(lambda x, y: x*y, ciag_liczb)


def palindrom(text):
    text = ''.join(filter(str.isalpha, text)).lower()
    if text == text[::-1]:
        return True
    else:
        return False


def tokenize(text):
    text = text.lower().split()
    text2 = []
    for x in text:
        text2.append(re.sub("\W+", "", x))
    text2 = list(filter(None, text2))
    return text2


def remove_stop_words(text):
    with open('stopwords.txt', encoding='UTF-8') as input_file:
        stopwords = input_file.read()
    stopwords = tokenize(stopwords)
    text = [word for word in text if word not in stopwords and len(word) > 2]
    return text


def count_most_frequent(text):
    text = tokenize(text)
    text = remove_stop_words(text)
    c = Counter(text)
    return c.most_common(20)


def zad7(word_list):
    word_list = word_list.split()
    anagram_list = []
    length = 0
    for word1 in word_list:
        for word2 in word_list:
            if word1 != word2 and sorted(word1) == sorted(word2):
                if len(word1) > length:
                    anagram_list = [word1, word2]
                    length = len(word1)
                    print((word1,word2))
    return anagram_list


def newMain():
    increment([1, 2, 3, 4])
    print(iloczyn([1, 2, 3, 4]))
    print(palindrom("Tolo ma samolot"))
    print(tokenize("To be, or not to be - that is the question [...]"))
    print(remove_stop_words(("ani", "bardziej", "konstantynopolitańczykowianeczka", "aa")))
    with open('trurl.txt', encoding='UTF-8') as input_file:
        trurl = input_file.read()
    print(count_most_frequent(trurl))
    with open('unixdict.txt', encoding='UTF-8') as input_file:
        unixdict = input_file.read()
    print(zad7(unixdict))


if __name__ == "__main__":
    newMain()
