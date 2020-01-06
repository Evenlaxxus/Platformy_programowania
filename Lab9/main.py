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


def newMain():
    increment([1, 2, 3, 4])
    print(iloczyn([1, 2, 3, 4]))
    print(palindrom("Tolo ma samolot"))
    print(tokenize("To be, or not to be - that is the question [...]"))
    print(remove_stop_words(("ani", "bardziej", "konstantynopolitańczykowianeczka", "aa")))
    print(count_most_frequent("asd asd asd dsf ani"))

if __name__ == "__main__":
    newMain()
