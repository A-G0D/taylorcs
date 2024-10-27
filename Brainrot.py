import sys
sys.stdin = open("Brainrot.in", "r")

def shift(s: str, o: int) -> str:
    res: str = ""
    for char in s:
        if not char.isalpha() or not char.islower():
            return s
        else:
            res += chr((ord(char) - ord('a') + o) % 26 + ord('a'))
    return res

def repl(sl: list[str]) -> list[str]:
    res = []
    for word in sl:
        w: bool = False
        for dist in range(1, 26):
            shifted: str = shift(word, dist)
            if shifted in ["skibidi", "rizz", "sigma", "gyatt"]:
                res.append(shifted)
                w = True
                break
        if not w:
            res.append(word)
    return res

n: int = int(input())

for i in range(n):
    l = input().split()
    print(" ".join(repl(l)))