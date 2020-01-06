import functools
import re

def increment(tab):
    gen_exp = (x + 1 for x in tab)
    for x in gen_exp:
        print(x)


def iloczyn(ciag_liczb):
    print(functools.reduce(lambda x, y: x*y, ciag_liczb))


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
    print(text2)


def newMain():
    increment([1, 2, 3, 4])
    iloczyn([1, 2, 3, 4])
    print(palindrom("Tolo ma samolot"))
    tokenize("To be, or not to be - that is the question [...]")


if __name__ == "__main__":
    newMain()
