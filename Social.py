import sys
sys.stdin = open("Social.in", "r")

n: int = int(input())
res: int = 0
for i in range(n):
    s: str
    t: str
    v: int
    s, t, v = input().split()
    v = int(v)
    if t == "Games":
        res += v / 10
    else:
        res -= v / 10
        
print("Games" if res > 0 else "Boba")