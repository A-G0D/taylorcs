import sys
sys.stdin = open("Calculus.in", "r")

l: list[int] = list(map(int, input().split()))
firstPow: int = len(l)
for i in range(len(l)):
    currPow: int = firstPow - i
    newPow: int = currPow - 1
    currCoeff: int = l[i]
    newCoeff: int = currCoeff * currPow
    operator: str = ""
    if (i != 0 and newCoeff >= 0):
        operator = "+"
    xPow: str = ""
    if (newPow > 0):
        xPow = "x^" + str(newPow)
    print(operator, newCoeff, xPow, end = "", sep = "")